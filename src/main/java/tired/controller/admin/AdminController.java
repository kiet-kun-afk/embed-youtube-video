package tired.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import tired.dto.VideoLikedInfo;
import tired.entity.User;
import tired.entity.Video;
import tired.service.StatsService;
import tired.service.UserService;
import tired.service.VideoService;

@Controller
public class AdminController {

    private static final String layout = "layout";

    @Autowired
    HttpServletRequest request;

    @Autowired
    VideoService videoService;

    @Autowired
    StatsService statsService;

    @Autowired
    UserService userService;

    @RequestMapping("admin")
    public String home(Model model) {
        List<VideoLikedInfo> videos = statsService.findVideoLikedInfo();
        model.addAttribute("videos", videos);
        model.addAttribute("ativeAside", "A");
        model.addAttribute(layout, "admin/home.jsp");
        return "layout";
    }

    @RequestMapping("admin/video")
    public String viewVideo(Model model) {
        List<Video> videos = videoService.findAll();
        model.addAttribute("videos", videos);
        model.addAttribute("ativeAside", "B");
        model.addAttribute("ativeAsideDown", "B1");
        model.addAttribute(layout, "admin/video-overview.jsp");
        return "layout";
    }

    @RequestMapping("admin/video/form")
    public String addVideo(Model model) {
        model.addAttribute("ativeAside", "B");
        model.addAttribute("ativeAsideDown", "B2");
        model.addAttribute("isEdit", false);
        model.addAttribute(layout, "admin/video-edit.jsp");
        return "layout";
    }

    @GetMapping("admin/video/edit")
    public String editVideo(Model model, @RequestParam("href") String href) {
        Video video = videoService.findByHref(href);
        model.addAttribute("ativeAside", "B");
        model.addAttribute("ativeAsideDown", "B2");
        model.addAttribute("isEdit", true);
        model.addAttribute("video", video);
        model.addAttribute(layout, "admin/video-edit.jsp");
        return "layout";
    }

    @DeleteMapping("admin/video/delete")
    public void deleteVideo(@RequestParam("href") String href) {
        videoService.delete(href);
    }

    @PostMapping("admin/video/new")
    public String addVideo(RedirectAttributes attributes,
            @RequestParam("title") String title,
            @RequestParam("href") String href,
            @RequestParam("description") String description) {
        Video video = new Video();
        video.setTitle(title);
        video.setHref(href);
        video.setDescription(description);
        video = videoService.create(video);
        if (video != null) {
            return "redirect:/admin/video";
        } else {
            attributes.addFlashAttribute("error", "Video could not create");
            String preString = request.getHeader("referer");
            return "redirect:" + preString;
        }
    }

    @PostMapping("admin/video/update")
    public String updateVideo(RedirectAttributes attributes,
            @RequestParam("oldHref") String oldHref,
            @RequestParam("title") String title,
            @RequestParam("href") String href,
            @RequestParam("description") String description) {
        Video video = videoService.findByHref(oldHref);
        video.setTitle(title);
        video.setHref(href);
        video.setDescription(description);
        video = videoService.update(video);
        if (video != null) {
            return "redirect:/admin/video";
        } else {
            attributes.addFlashAttribute("error", "Video could not update");
            String preString = request.getHeader("referer");
            return "redirect:" + preString;
        }
    }

    @GetMapping("admin/activeUsers")
    public String viewUserActive(Model model) {
        List<User> users = userService.findAllActive();
        model.addAttribute("users", users);
        model.addAttribute("ativeAside", "C");
        model.addAttribute("ativeAsideDown", "C1");
        model.addAttribute(layout, "admin/user-overview.jsp");
        return "layout";
    }

    @DeleteMapping("admin/user/delete")
    public void deleteUser(@RequestParam("username") String username) {
        userService.delete(username);
    }

    @GetMapping("admin/inactiveUsers")
    public String viewUserInactive(Model model) {
        List<User> users = userService.findAllInactive();
        model.addAttribute("users", users);
        model.addAttribute("ativeAside", "C");
        model.addAttribute("ativeAsideDown", "C2");
        model.addAttribute(layout, "admin/user-overview.jsp");
        return "layout";
    }

    @GetMapping("admin/user/activation")
    public void activeUser(@RequestParam("username") String username) {
        User user = userService.findByUsernameAndIsActiveFalse(username);
        userService.activeUser(user);
    }
}