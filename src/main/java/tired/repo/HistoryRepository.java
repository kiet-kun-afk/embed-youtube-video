package tired.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tired.entity.History;

public interface HistoryRepository extends JpaRepository<History, Integer> {

	History findByUserIdAndVideoId(Integer userId, Integer videoId);
	
	@Query("SELECT o FROM History o WHERE o.user.username = ?1 AND o.video.isActive = true ORDER BY o.viewedDate DESC")
	List<History> findByUserAndVideoActive(String username);
	
	@Query("SELECT o FROM History o WHERE o.user.username = ?1 AND o.isLiked = true AND o.video.isActive = true ORDER BY o.viewedDate DESC")
	List<History> findByUserAndIsLiked(String username);
}
