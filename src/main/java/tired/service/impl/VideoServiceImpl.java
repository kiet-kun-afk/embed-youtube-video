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
	public Video findById(Integer id) {
		return videoRepository.findById(id).get();
	}

	@Override
	public Video findByHref(String href) {
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
	public Page<Video> findRandom(Pageable pageNumber) {
		return videoRepository.findRandom(pageNumber);
	}

	@Override
	public Video create(Video entity) {
		entity.setIsActive(Boolean.TRUE);
		entity.setViews(0);
		entity.setShares(0);
		if (entity.getTitle().equals("") || entity.getHref().equals("")) {
			return null;
		} else {
			entity.setPoster("https://img.youtube.com/vi/" + entity.getHref() + "/maxresdefault.jpg");
			return videoRepository.save(entity);
		}
	}

	@Override
	public Video update(Video entity) {
		if (entity.getTitle().equals("") || entity.getHref().equals("")) {
			return null;
		} else {
			entity.setPoster("https://img.youtube.com/vi/" + entity.getHref() + "/maxresdefault.jpg");
			return videoRepository.save(entity);
		}
	}

	@Override
	public Video upViews(Video entity) {
		Integer views = entity.getViews() + 1;
		entity.setViews(views);
		return videoRepository.save(entity);
	}

	@Override
	public Video upShare(Video entity) {
		Integer share = entity.getShares() + 1;
		entity.setShares(share);
		return videoRepository.save(entity);
	}

	@Override
	public Video delete(String href) {
		Video video = videoRepository.findByHrefAndIsActiveTrue(href);
		video.setIsActive(Boolean.FALSE);
		return videoRepository.save(video);
	}

}
