package tired.service;

import java.util.List;

import tired.entity.User;

public interface UserService {

	List<User> findAllActive();

	User findByEmail(String email);

	User findByUserName(String username);

	User findExistUsername(String username);

	User findExistEmail(String email);

	User findByUsernameAndIsActiveFalse(String username);

	List<User> findAllInactive();

	User resetPassword(String email);

	User register(User user);

	User activeUser(User user);

	User update(User entity);

	User delete(String username);
}
