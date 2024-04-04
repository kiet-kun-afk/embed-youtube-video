package tired.service.impl;

import java.util.List;
import java.util.Random;

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
		if (email == null || email.isEmpty()) {
			return null;
		}
		return userRepository.findByEmailAndIsActiveTrue(email);
	}

	@Override
	public User findByUserName(String username) {
		if (username == null || username.isEmpty()) {
			return null;
		}
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
			Random random = new Random();

			int randomNumber = random.nextInt(10000) + 1;

			String randomString;
			if (randomNumber < 10) {
				randomString = "000" + randomNumber;
			} else if (randomNumber < 100) {
				randomString = "00" + randomNumber;
			} else if (randomNumber < 1000) {
				randomString = "0" + randomNumber;
			} else {
				randomString = Integer.toString(randomNumber);
			}
			User user = new User();
			user.setUsername(existUser.getUsername());
			user.setEmail(existUser.getEmail());
			user.setPassword(randomString);
			existUser.setPassword(passwordEncoder.encode(randomString));
			userRepository.save(existUser);
			return user;
		}
		return null;
	}

	@Override
	public User register(User user) {
		if (user != null) {
			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public User activeUser(User user) {
		if (user != null) {
			user.setIsActive(true);
			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public User update(User entity) {
		if (entity != null) {
			return userRepository.save(entity);
		}
		return null;
	}

	@Override
	public User delete(String username) {
		if (username.isEmpty() || username == null) {
			return null;
		}
		User user = userRepository.findByUsernameAndIsActiveTrue(username);
		if (user != null) {
			user.setIsActive(Boolean.FALSE);
			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public User findByUsernameAndIsActiveFalse(String username) {
		if (username.isEmpty() || username == null) {
			return null;
		}
		return userRepository.findByUsernameAndIsActiveFalse(username);
	}

	@Override
	public User findExistUsername(String username) {
		if (username.isEmpty() || username == null) {
			return null;
		}
		return userRepository.findByUsername(username);
	}

	@Override
	public User findExistEmail(String email) {
		if (email.isEmpty() || email == null) {
			return null;
		}
		return userRepository.findByEmail(email);
	}

}
