package tired.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import tired.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {
	
	@Autowired
	HttpSession session;
	
	@Override
	public void setAttribute(String name, Object value) {
		session.setAttribute(name, value);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAttribute(String key){
		if(session.getAttribute(key)!=null)
			return (T) session.getAttribute(key);
		else 
			return null;
	}
	
	@Override
	public void removeAttribute(String name) {
		session.removeAttribute(name);
	}

}
