package tired.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tired.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsernameAndIsActiveTrue(String username);
	
	User findByEmailAndIsActiveTrue(String email);
}
