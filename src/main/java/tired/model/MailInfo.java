package tired.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailInfo {
	
	String from = "kietmnvps27065@fpt.edu.vn";
	
	String to;
	
	String[] cc;
	
	String[] bcc;
	
	String subject;
	
	String body;
	
	List<File> files = new ArrayList<>();
}
