package tired.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tired.entity.Video;
import tired.repo.VideoRepository;
import tired.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	VideoRepository videoRepository;

	@Override
	public List<Video> getInactiveVideos() {
		return videoRepository.findByIsActiveFalse();
	}

	@Override
	public Video findByHref(String href) {
		if (href == null || href.isEmpty()) {
			return null;
		}
		return videoRepository.findByHrefAndIsActiveTrue(href);
	}

	@Override
	public List<Video> findAll() {
		return videoRepository.findAllActive();
	}

	@Override
	public Page<Video> findAll(int pageNumber, int pageSize) {
		Pageable pageAble = PageRequest.of(pageNumber, pageSize);
		return videoRepository.findAllActive(pageAble);
	}

	@Override
	public Page<Video> findRandom(Pageable pageNumber, String href) {
		return videoRepository.findRandom(pageNumber, href);
	}

	@Override
	public Video create(Video entity) {
		if (entity != null) {
			if (entity.getTitle().equals("") || entity.getHref().equals("")) {
				return null;
			} else {
				entity.setIsActive(Boolean.TRUE);
				entity.setViews(0);
				entity.setShares(0);
				entity.setPoster("https://img.youtube.com/vi/" + entity.getHref() + "/maxresdefault.jpg");
				return videoRepository.save(entity);
			}
		}
		return null;
	}

	@Override
	public Video update(Video entity) {
		if (entity != null) {
			if (entity.getTitle().equals("") || entity.getHref().equals("")) {
				return null;
			} else {
				entity.setPoster("https://img.youtube.com/vi/" + entity.getHref() + "/maxresdefault.jpg");
				return videoRepository.save(entity);
			}
		}
		return null;
	}

	@Override
	public Video upViews(Video entity) {
		if (entity != null) {
			Integer views = entity.getViews() + 1;
			entity.setViews(views);
			return videoRepository.save(entity);
		}
		return null;
	}

	@Override
	public Video upShare(Video entity) {
		if (entity != null) {
			Integer share = entity.getShares() + 1;
			entity.setShares(share);
			return videoRepository.save(entity);
		}
		return null;
	}

	@Override
	public Video delete(String href) {
		if (href == null || href.isEmpty()) {
			return null;
		}
		Video video = videoRepository.findByHrefAndIsActiveTrue(href);
		if (video == null) {
			return null;
		}
		video.setIsActive(Boolean.FALSE);
		return videoRepository.save(video);
	}

	@Override
	public Video findVideoInactiveByHref(String href) {
		if (href == null || href.isEmpty()) {
			return null;
		}
		return videoRepository.findByHrefAndIsActiveFalse(href);
	}

	@Override
	public Video recoverVideo(Video video) {
		if (video != null) {
			video.setIsActive(Boolean.TRUE);
			return videoRepository.save(video);
		}
		return null;
	}

	@Override
	public Video findExistVideo(String href) {
		if (href == null || href.isEmpty()) {
			return null;
		}
		return videoRepository.findByHref(href);
	}

	@Override
	public List<Video> findExistVideoExcludingCurrent(Video video, String href) {
		return videoRepository.findAllByHrefAndIdNot(href, video.getId());
	}

}
