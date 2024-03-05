package tired.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import tired.constant.SessionAttr;
import tired.entity.User;
import tired.service.EmailService;
import tired.service.SessionService;
import tired.service.UserService;

@Controller
public class UserController {
	
	private static final String layout = "view";
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SessionService session;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("forgotPass")
	public String getForgot(Model model) {
		model.addAttribute(layout, "user/forgot-pass.jsp");
		return "index";
	}
	
	@PostMapping("forgotPass")
	public String postForgot(@RequestParam("email") String email, HttpServletResponse response){
		response.setContentType("application/json");
		User userWithNewPass = userService.resetPassword(email);
		if (userWithNewPass != null) {
			emailService.send(userWithNewPass, "forgot");
			response.setStatus(204);
		} else {
			response.setStatus(400);
		}
		return "redirect:/index";
	}
	
	@PostMapping("changePass")
	public String changePass(@RequestParam("currentPass") String currentPass, @RequestParam("newPass") String newPass, HttpServletResponse response) {
		response.setContentType("application/json");
		User currentUser = session.getAttribute(SessionAttr.CURRENT_USER);
		if (passwordEncoder.matches(currentPass, currentUser.getPassword())) {
			currentUser.setPassword(passwordEncoder.encode(newPass));
			User updatedUser = userService.update(currentUser);
			if (updatedUser != null) {
				session.setAttribute(SessionAttr.CURRENT_USER, updatedUser);
				response.setStatus(204);
			} else {
				response.setStatus(400);
			}
		} else {
			response.setStatus(400);
		}
		return "redirect:/index";
	}
}
