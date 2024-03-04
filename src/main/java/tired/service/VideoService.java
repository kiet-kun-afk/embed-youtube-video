package tired.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tired.entity.Video;

@Service
public interface VideoService {

	Video findById(Integer id);

	Video findByHref(String href);

	List<Video> findAll();

	List<Video> findAll(int pageNumber, int pageSize);

	List<Video> findRandom();

	Video create(Video entity);

	Video update(Video entity);

	Video upViews(Video entity);

	Video upShare(Video entity);

	Video delete(String href);
}
