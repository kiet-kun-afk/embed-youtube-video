package tired.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tired.constant.SessionAttr;
import tired.entity.History;
import tired.entity.User;
import tired.entity.Video;
import tired.service.EmailService;
import tired.service.HistoryService;
import tired.service.SessionService;
import tired.service.VideoService;

@Controller
@RequestMapping("video")
public class VideoController {

	private static final String layout = "view";

	@Autowired
	SessionService session;

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	@Autowired
	HistoryService historyService;

	@Autowired
	EmailService emailService;

	@Autowired
	VideoService videoService;

	@GetMapping("watch")
	public String getWatch(Model model, @RequestParam("p") String href) {
		Video video = videoService.findByHref(href);
		Pageable pageNumber = PageRequest.of(0, 5);
		Page<Video> videos = videoService.findRandom(pageNumber);
		videoService.upViews(video);
		User user = session.getAttribute(SessionAttr.CURRENT_USER);
		if (user != null) {
			History history = historyService.create(user, video);
			model.addAttribute("flagLikedBtn", history.getIsLiked());
		}
		model.addAttribute("video", video);
		model.addAttribute("videos", videos);
		model.addAttribute(layout, "video-detail.jsp");
		return "index";
	}

	@GetMapping("like")
	public String doLike(@RequestParam("p") String href) {
		response.setContentType("application/json");
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		boolean result = historyService.updateLikeOrUnlike(currentUser, href);
		if (result == true) {
			response.setStatus(204);
		} else {
			response.setStatus(400);
		}
		return "redirect:/index";
	}

	@GetMapping("share")
	public String doShare(@RequestParam("p") String href) {
		String recipient = request.getParameter("recipient");
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		response.setContentType("application/json");
		Video video = videoService.findByHref(href);
		try {
			emailService.share(currentUser, recipient, video);
			videoService.upShare(video);
			response.setStatus(204);
		} catch (Exception e) {
			response.setStatus(400);
			e.printStackTrace();
		}
		return "redirect:/index";
	}
}
