package tired.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tired.entity.History;
import tired.entity.User;
import tired.entity.Video;

@Service
public interface HistoryService {

	List<History> findByUser(String username);

	List<History> findByUserAndIsLiked(String username);

	History findByUserIdAndVideoId(Integer userId, Integer videoId);

	History create(User user, Video video);

	Boolean updateLikeOrUnlike(User user, String videoHref);
}
