package tired.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tired.dto.VideoLikedInfo;
import tired.repo.VideoRepository;
import tired.service.StatsService;

@Service
public class StatsServiceImpl implements StatsService {

	@Autowired
	VideoRepository videoRepository;

	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		List<String[]> objects = videoRepository.getInfoLikedVideo();
		List<VideoLikedInfo> result = new ArrayList<>();
		objects.forEach(object -> {
			VideoLikedInfo videoLikedInfo = setDataVideoLikedInfo(object);
			result.add(videoLikedInfo);
		});
		return result;
	}

	private VideoLikedInfo setDataVideoLikedInfo(String[] object) {
		VideoLikedInfo videoLikedInfo = new VideoLikedInfo();
		videoLikedInfo.setId((String)object[0]);
		videoLikedInfo.setTitle((String)object[1]);
		videoLikedInfo.setHref((String)object[2]);
		videoLikedInfo.setLike((String)object[3]);
		return videoLikedInfo;
	}
}
