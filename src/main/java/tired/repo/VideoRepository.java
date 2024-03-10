package tired.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tired.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

	List<Video> findAllByHrefAndIdNot(String href, Integer id);

	Video findByHref(String href);

	Video findByHrefAndIsActiveTrue(String href);

	Video findByHrefAndIsActiveFalse(String href);

	List<Video> findByIsActiveFalse();

	@Query("SELECT o FROM Video o WHERE isActive = true")
	List<Video> findAllActive();

	@Query("SELECT o FROM Video o WHERE isActive = true")
	Page<Video> findAllActive(Pageable pageable);

	@Query(value = "SELECT o FROM Video o WHERE o.isActive = true AND o.href <> :href ORDER BY NEWID()")
	Page<Video> findRandom(Pageable pageable, @Param("href") String href);

	@Query("SELECT v.id, v.title, v.href, SUM(CAST(h.isLiked as int)) AS likes "
			+ "FROM Video v INNER JOIN History h ON v.id = h.video.id WHERE v.isActive = true "
			+ "GROUP BY v.id, v.title, v.href HAVING SUM(CAST(h.isLiked AS INTEGER)) > 0")
	List<String[]> getInfoLikedVideo();
}