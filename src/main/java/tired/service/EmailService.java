package tired.service;

import tired.entity.User;
import tired.entity.Video;

public interface EmailService {

	void send(User recipient, String type);

	void share(User sender, String recipient, Video video);
}
