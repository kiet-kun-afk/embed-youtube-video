package tired.service;

import java.util.List;

import tired.dto.UserDto;
import tired.entity.User;

public interface UserService {

	User findByID(Integer id);

	User findByEmail(String email);

	User findByUserName(String username);

	User login(String username, String password);

	User resetPassword(String email);

	List<User> findAll();

	List<User> findAll(int pageNumber, int pageSize);

	User register(String username, String password, String email);

	User create(String username, String password, String email, Boolean isadmin);

	User update(User entity);

	User delete(String username);

	List<UserDto> findUsersLikedVideoByVideoHref(String href);
}
