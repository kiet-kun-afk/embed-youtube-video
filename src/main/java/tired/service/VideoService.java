package tired.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tired.entity.Video;

public interface VideoService {

	Video findById(Integer id);

	Video findByHref(String href);

	List<Video> findAll();

	Page<Video> findAll(int pageNumber, int pageSize);

	Page<Video> findRandom(Pageable pageNumber);

	Video create(Video entity);

	Video update(Video entity);

	Video upViews(Video entity);

	Video upShare(Video entity);

	Video delete(String href);
}
