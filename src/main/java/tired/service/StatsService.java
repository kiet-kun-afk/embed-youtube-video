package tired.service;

import java.util.List;

import tired.dto.VideoLikedInfo;

public interface StatsService {

	List<VideoLikedInfo> findVideoLikedInfo();
}
