package tired.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tired.entity.Video;
import tired.repo.VideoRepository;
import tired.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

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
	public List<Video> findAll(int pageNumber, int pageSize) {
		return null;
	}

	@Override
	public List<Video> findRandom() {
		Pageable pageable = PageRequest.of(0, 6);
		return videoRepository.findRandom(pageable);
	}

	@Override
	public Video create(Video entity) {
		return null;
	}

	@Override
	public Video update(Video entity) {
		return null;
	}

	@Override
	public Video upViews(Video entity) {
		return null;
	}

	@Override
	public Video upShare(Video entity) {
		return null;
	}

	@Override
	public Video delete(String href) {
		return null;
	}

}
