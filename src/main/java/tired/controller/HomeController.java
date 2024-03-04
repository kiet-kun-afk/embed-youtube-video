package tired.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tired.entity.Video;
import tired.repo.VideoRepository;
import tired.service.HistoryService;
import tired.service.VideoService;
import tired.service.impl.HistoryServiceImpl;
import tired.service.impl.VideoServiceImpl;

@Controller
public class HomeController {

	@Autowired
	VideoRepository videoRepository;
	
	private static final int PAGE_ELEMENT = 4;
	private static final String layout = "view";
	private VideoService videoService = new VideoServiceImpl();
	private HistoryService historyService = new HistoryServiceImpl();

	@GetMapping("index")
	public String getIndex(Model model, @RequestParam("page") Optional<Integer> pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber.orElse(0), PAGE_ELEMENT);
		Page<Video> videos = videoRepository.findAllActive(pageable);
		model.addAttribute("videos", videos);
		model.addAttribute(layout, "user/home.jsp");
		return "index";
	}
}
