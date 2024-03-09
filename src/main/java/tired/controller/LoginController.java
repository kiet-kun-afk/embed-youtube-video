package tired.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("view", "login.jsp");
		return "index";
	}

	@RequestMapping("/accessDenied")
	public String accessDenied(RedirectAttributes attributes) {
		attributes.addFlashAttribute("message", "Your role is not accepted");
		return "redirect:/index";
	}

	@RequestMapping("/success")
	public String handleLoginSuccess(RedirectAttributes attributes) {
		attributes.addFlashAttribute("message", "Login success");
		return "redirect:/index";
	}

	@RequestMapping("/failure")
	public String handleLoginFailure(RedirectAttributes attributes) {
		attributes.addFlashAttribute("message", "Email or password is not true");
		return "redirect:/login";
	}
}
