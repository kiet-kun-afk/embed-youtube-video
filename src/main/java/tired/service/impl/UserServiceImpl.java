package tired.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tired.entity.User;
import tired.repo.UserRepository;
import tired.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> findAllActive() {
		return userRepository.findByIsActiveTrueAndRole_Name("USER");
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmailAndIsActiveTrue(email);
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsernameAndIsActiveTrue(username);
	}

	@Override
	public List<User> findAllInactive() {
		return userRepository.findByIsActiveFalse();
	}

	@Override
	public User resetPassword(String email) {
		User existUser = findByEmail(email);
		if (existUser != null) {
			// (Math.random()) * ((max - min) + 1)) + min
			String newPass = String.valueOf((int) (Math.random() * ((9999 - 1000) + 1)) + 1000);
			existUser.setPassword(passwordEncoder.encode(newPass));
			User user = userRepository.save(existUser);
			user.setPassword(newPass);
			return user;
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return null;
	}

	@Override
	public User register(User user) {
		return userRepository.save(user);
	}

	@Override
	public User activeUser(User user) {
		user.setIsActive(true);
		return userRepository.save(user);
	}

	@Override
	public User update(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public User delete(String username) {
		User user = userRepository.findByUsernameAndIsActiveTrue(username);
		user.setIsActive(Boolean.FALSE);
		return userRepository.save(user);
	}

	@Override
	public User findByUsernameAndIsActiveFalse(String username) {
		return userRepository.findByUsernameAndIsActiveFalse(username);
	}

}
