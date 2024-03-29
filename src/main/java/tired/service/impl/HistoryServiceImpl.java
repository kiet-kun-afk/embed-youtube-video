package tired.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tired.entity.History;
import tired.entity.User;
import tired.entity.Video;
import tired.repo.HistoryRepository;
import tired.repo.VideoRepository;
import tired.service.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	HistoryRepository historyRepository;

	@Autowired
	VideoRepository videoRepository;

	@Override
	public List<History> findByUser(String username) {
		if (username == null) {
			return null;
		}
		return historyRepository.findByUserAndVideoActive(username);
	}

	@Override
	public List<History> findByUserAndIsLiked(String username) {
		if (username == null) {
			return null;
		}
		return historyRepository.findByUserAndIsLiked(username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		if (userId == null || videoId == null) {
			return null;
		}
		return historyRepository.findByUserIdAndVideoId(userId, videoId);
	}

	@Override
	public History create(User user, Video video) {
		if (video == null || video == null) {
			return null;
		}
		History existHistory = historyRepository.findByUserIdAndVideoId(user.getId(), video.getId());
		if (existHistory == null) {
			existHistory = new History();
			existHistory.setUser(user);
			existHistory.setVideo(video);
			existHistory.setViewedDate(new Timestamp(System.currentTimeMillis()));
			existHistory.setIsLiked(Boolean.FALSE);
			historyRepository.save(existHistory);
		}
		return existHistory;
	}

	@Override
	public Boolean updateLikeOrUnlike(User user, String videoHref) {
		if (user == null || videoHref == null || videoHref.isEmpty()) {
			return false;
		}
		Video video = videoRepository.findByHrefAndIsActiveTrue(videoHref);
		if (video == null) {
			return false;
		}
		History existHistory = findByUserIdAndVideoId(user.getId(), video.getId());
		if (existHistory == null) {
			return false;
		}
		if (existHistory.getIsLiked() == Boolean.FALSE) {
			existHistory.setIsLiked(Boolean.TRUE);
			existHistory.setLikedDate(new Timestamp(System.currentTimeMillis()));
		} else {
			existHistory.setIsLiked(Boolean.FALSE);
			existHistory.setLikedDate(null);
		}
		History updateHistory = historyRepository.save(existHistory);
		return updateHistory != null ? true : false;
	}

}
