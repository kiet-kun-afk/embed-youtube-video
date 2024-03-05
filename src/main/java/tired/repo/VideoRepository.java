package tired.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tired.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
	
	Video findByHrefAndIsActiveTrue(String href);
	
	@Query("SELECT o FROM Video o WHERE isActive = true")
	List<Video> findAllActive();
	
	@Query("SELECT o FROM Video o WHERE isActive = true")
	Page<Video> findAllActive(Pageable pageable);
	
	@Query(value = "SELECT o FROM Video o WHERE isActive = true ORDER BY NEWID()")
	Page<Video> findRandom(Pageable pageable);

	@Query("SELECT v.id, v.title, v.href, SUM(CAST(h.isLiked as int)) AS totalLike "
			+ "FROM Video v LEFT JOIN History h ON v.id = h.video.id WHERE v.isActive = true "
			+ "GROUP BY v.id, v.title, v.href")
	List<Object[]> getInfoLikedVideo();
}