package tired.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.ServletContext;
import tired.entity.User;
import tired.entity.Video;

@Service
public interface EmailService {

	void sendMail(ServletContext context, User recipient, String type);

	void shareVideo(ServletContext context, User sender, String recipient, Video video);

}
