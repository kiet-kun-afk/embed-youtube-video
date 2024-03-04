package tired.service;

import org.springframework.stereotype.Service;

@Service
public interface SessionService {
	
	public void setAttribute(String key, Object value);

	public <T> T getAttribute(String key);

	public void removeAttribute(String key);
}
