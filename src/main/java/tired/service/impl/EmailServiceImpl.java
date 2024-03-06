package tired.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import tired.entity.User;
import tired.entity.Video;
import tired.model.MailInfo;
import tired.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	private final String EMAIL_WELCOME_SUBJECT = "Welcome!";
	private final String EMAIL_FORGOT_PASSWORD = "Forgot password";

	@Autowired
	JavaMailSender sender;

	@Override
	public void send(User recipient, String type){
		try {
			String content = null;
			String subject = null;
			switch (type) {
			case "welcome":
				subject = EMAIL_WELCOME_SUBJECT;
				content = "Dear " + recipient.getUsername() + ", hope you have a good time!";
				break;
			case "forgot":
				subject = EMAIL_FORGOT_PASSWORD;
				content = "Dear " + recipient.getUsername() + ", your new password here: " + recipient.getPassword();
				break;
			default:
				subject = "Online Entertainment";
				content = "Maybe this email is wrong, don't care about it";
				break;
			}
			MailInfo mail = new MailInfo();
			mail.setFrom(mail.getFrom());
			mail.setTo(recipient.getEmail());
			mail.setSubject(subject);
			mail.setBody(content);
			sendEmail(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void share(User sender, String recipient, Video video){
		try {
			String content = null;
			String subject = null;
			subject = "Hallo, " + sender.getUsername() + " share this video for you";
			content = "Dear " + recipient + ", you was shared this video from: " + sender.getEmail()
					+ ". Link to watch video: http://localhost:8080/video/watch?p="
					+ video.getHref();
			MailInfo mail = new MailInfo();
			mail.setFrom(mail.getFrom());
			mail.setTo(recipient);
			mail.setSubject(subject);
			mail.setBody(content);
			sendEmail(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendEmail(MailInfo mail) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getTo());
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getBody(), true);
		helper.setReplyTo(mail.getFrom());

		String[] cc = mail.getCc();
		if (cc != null && cc.length > 0) {
			helper.setCc(cc);
		}

		String[] bcc = mail.getBcc();
		if (bcc != null && bcc.length > 0) {
			helper.setBcc(bcc);
		}

		List<File> files = mail.getFiles();
		if (files.size() > 0) {
			for (File file : files) {
				helper.addAttachment(file.getName(), file);
			}
		}
		sender.send(message);
	}
}
