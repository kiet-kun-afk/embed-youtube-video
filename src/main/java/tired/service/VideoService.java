package tired.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tired.entity.Video;

public interface VideoService {

	List<Video> getInactiveVideos();

	List<Video> findExistVideoExcludingCurrent(Video video, String href);

	Video findExistVideo(String href);

	Video findByHref(String href);

	Video findVideoInactiveByHref(String href);

	List<Video> findAll();

	Page<Video> findAll(int pageNumber, int pageSize);

	Page<Video> findRandom(Pageable pageNumber, String href);

	Video create(Video entity);

	Video update(Video entity);

	Video upViews(Video entity);

	Video upShare(Video entity);

	Video delete(String href);

	Video recoverVideo(Video video);
}
