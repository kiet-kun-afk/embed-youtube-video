package tired.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@GetMapping("forgotPass")
	public String getForgot(Model model) {
		model.addAttribute(layout, "user/forgot-pass.jsp");
		return "index";
	}

	@PostMapping("forgotPass")
	public String postForgot(Model model, @RequestParam("email") String email) throws IOException {
		User userWithNewPass = userService.resetPassword(email);
		if (userWithNewPass != null) {
			emailService.send(userWithNewPass, "forgot");
			logger.info("An email with password reset instructions has been sent to your email.");
			model.addAttribute("forgot_pass", "An email with password reset instructions has been sent to your email.");
		} else {
			logger.info("Your email is incorrect or has not been registered.");
			model.addAttribute("forgot_pass_wrong", "Your email is incorrect or has not been registered.");
		}
		model.addAttribute(layout, "user/forgot-pass.jsp");
		return "index";
	}

	@PostMapping("changePass")
	public String changePass(RedirectAttributes attributes, @RequestParam("currentPass") String currentPass,
			@RequestParam("newPass") String newPass) {
		User currentUser = session.getAttribute(SessionAttr.CURRENT_USER);
		if (passwordEncoder.matches(currentPass, currentUser.getPassword())) {
			currentUser.setPassword(passwordEncoder.encode(newPass));
			User updatedUser = userService.update(currentUser);
			if (updatedUser != null) {
				session.setAttribute(SessionAttr.CURRENT_USER, updatedUser);
				logger.info("Password changed successfully!");
				attributes.addFlashAttribute("change_pass", "Password changed successfully!");
			} else {
				logger.info("Failed to change password. Please try again.");
				attributes.addFlashAttribute("change_pass", "Failed to change password. Please try again.");
			}
		} else {
			logger.info("Current password is incorrect.");
			attributes.addFlashAttribute("change_pass", "Current password is incorrect.");
		}
		return "redirect:/index";
	}
}
