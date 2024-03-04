package tired.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tired.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsernameAndIsActiveTrue(String username);
	
	User findByEmailAndIsActiveTrue(String email);
}
