package tired.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tired.constant.SessionAttr;
import tired.entity.History;
import tired.entity.User;
import tired.entity.Video;
import tired.service.HistoryService;
import tired.service.SessionService;
import tired.service.UserService;
import tired.service.VideoService;

@Controller
public class HomeController {

	SessionAttr sessionAttr = new SessionAttr();

	@Autowired
	VideoService videoService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	HistoryService historyService;

	@Autowired
	SessionService session;

	private static final int PAGE_ELEMENT = 8;
	private static final String layout = "view";

	@GetMapping("/")
	public String returnIndex() {
		return "redirect:/index";
	}

	@GetMapping("index")
	public String getIndex(Model model, @RequestParam("page") Optional<Integer> pageNumber) {
		getAuthen();
		Page<Video> videos = videoService.findAll(pageNumber.orElse(0), PAGE_ELEMENT);
		model.addAttribute("videos", videos);
		model.addAttribute(layout, "home.jsp");
		return "index";
	}

	@GetMapping("history")
	public String getHistory(Model model) {
		List<History> histories = historyService.findByUser(getAuthen().getUsername());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		model.addAttribute("videos", videos);
		model.addAttribute(layout, "user/history.jsp");
		return "index";
	}

	@GetMapping("favorites")
	public String getFavorites(Model model) {
		List<History> histories = historyService.findByUserAndIsLiked(getAuthen().getUsername());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		model.addAttribute("videos", videos);
		model.addAttribute(layout, "user/history.jsp");
		return "index";
	}

	private User getAuthen() {
		User user = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		user = userService.findByUserName(authentication.getName());
		if (user != null) {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
		}
		return user;
	}
}
