package tired.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tired.dto.VideoLikedInfo;

@Service
public interface StatsService {

	List<VideoLikedInfo> findVideoLikedInfo();
}
