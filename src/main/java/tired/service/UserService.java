package tired.service;

import java.util.List;

import tired.entity.User;

public interface UserService {

	List<User> findAllActive();

	User findByEmail(String email);

	User findByUserName(String username);

	User findByUsernameAndIsActiveFalse(String username);

	List<User> findAllInactive();

	User resetPassword(String email);

	List<User> findAll();

	List<User> findAll(int pageNumber, int pageSize);

	User register(User user);

	User activeUser(User user);

	User update(User entity);

	User delete(String username);
}
