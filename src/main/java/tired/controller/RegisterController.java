package tired.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.apiclub.captcha.Captcha;
import tired.entity.Role;
import tired.entity.Role.RoleEnum;
import tired.entity.User;
import tired.repo.RoleRepository;
import tired.repo.UserRepository;
import tired.util.CaptchaUtil;

@Controller
public class RegisterController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("register")
	public String registerUser(Model model) {
		User user = new User();
		getCaptcha(user);
		model.addAttribute("realCaptcha", user.getRealCaptcha());
		model.addAttribute("hiddenCaptcha", user.getHiddenCaptcha());
		model.addAttribute("captcha", user.getCaptcha());
		model.addAttribute("view", "register.jsp");
		return "index";
	}

	private void getCaptcha(User user) {
		Captcha captcha = CaptchaUtil.createCaptcha(240, 70);
		user.setHiddenCaptcha(captcha.getAnswer());
		user.setCaptcha(""); // value entered
		user.setRealCaptcha(CaptchaUtil.encodeCaptcha(captcha));
	}

	@PostMapping("/handle-register")
	public String handleRegister(RedirectAttributes attributes,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("cfmpass") String cfmpass,
			@RequestParam("email") String email,
			@RequestParam(name = "role", required = false) String role,
			@RequestParam("captcha") String captcha,
			@RequestParam("hiddenCaptcha") String hiddenCaptcha) {

		if (!password.equals(cfmpass)) {
			attributes.addFlashAttribute("message", "Passwords do not match!");
			return "redirect:/register";
		}
		Role newRole = null;
		Map<String, RoleEnum> roleMap = Map.of("admin", RoleEnum.ADMIN, "user", RoleEnum.USER);

		if (role != null) {
			RoleEnum roleEnum = roleMap.get(role.toLowerCase());
			if (roleEnum != null) {
				newRole = roleRepository.findByName(roleEnum.name());
				if (newRole == null) {
					newRole = new Role(roleEnum);
				}
			}
		} else {
			Role defaultRole = roleRepository.findByName("USER");
			if (defaultRole == null) {
				newRole = new Role(RoleEnum.USER);
			} else {
				newRole = defaultRole;
			}
		}

		roleRepository.save(newRole);

		if (captcha.equals(hiddenCaptcha)) {
			userRepository.save(
					User.builder()
					.username(username)
					.password(passwordEncoder
							.encode(password))
					.role(newRole)
					.isActive(true)
					.email(email)
					.build());
		} else {
			attributes.addFlashAttribute("message", "Captcha does not match!");
			return "redirect:/register";
		}
		attributes.addFlashAttribute("message", "Sign up success");
		return "redirect:/login";
	}
}
