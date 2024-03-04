package tired.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tired.dto.UserDto;
import tired.entity.User;
import tired.repo.UserRepository;
import tired.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findByID(Integer id) {
		return null;
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
	public User login(String username, String password) {
		return null;
	}

	@Override
	public User resetPassword(String email) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return null;
	}

	@Override
	public User register(String username, String password, String email) {
		return null;
	}

	@Override
	public User create(String username, String password, String email, Boolean isadmin) {
		return null;
	}

	@Override
	public User update(User entity) {
		return null;
	}

	@Override
	public User delete(String username) {
		return null;
	}

	@Override
	public List<UserDto> findUsersLikedVideoByVideoHref(String href) {
		return null;
	}
	
}
