package tired.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tired.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	User findByEmail(String email);

	User findByUsernameAndIsActiveTrue(String username);

	User findByUsernameAndIsActiveFalse(String username);

	User findByEmailAndIsActiveTrue(String email);

	List<User> findByIsActiveTrueAndRole_Name(String roleName);

	List<User> findByIsActiveFalse();
}
