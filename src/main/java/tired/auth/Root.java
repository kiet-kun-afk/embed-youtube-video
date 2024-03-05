package tired.auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import tired.entity.User;

@SuppressWarnings("serial")
@Builder
public class Root implements UserDetails {
	
	private User user;
	private List<GrantedAuthority> authorities;

	public static Root create(User user) {
		return Root
				.builder()
				.user(user)
				.authorities(Arrays.stream(user.getRole().getName().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList()))
				.build();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
