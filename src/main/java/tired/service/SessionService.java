package tired.service;

public interface SessionService {
	
	public void setAttribute(String key, Object value);

	public <T> T getAttribute(String key);

	public void removeAttribute(String key);
}
