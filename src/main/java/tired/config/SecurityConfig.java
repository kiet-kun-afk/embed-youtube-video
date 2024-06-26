package tired.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import tired.auth.MyUserDetailsService;

@EnableMethodSecurity()
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final MyUserDetailsService myUserDetailsService;

	@Bean
	BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(myUserDetailsService);
		authProvider.setPasswordEncoder(getPasswordEncoder());
		return authProvider;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(req -> req
						.requestMatchers("/history", "favorites", "admin", "admin/**")
						.authenticated()
						.anyRequest()
						.permitAll())
				.formLogin(form -> form
						.loginPage("/login")
						.usernameParameter("username")
						.passwordParameter("password")
						.loginProcessingUrl("/login-request")
						.defaultSuccessUrl("/success")
						.failureUrl("/failure"))
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/index")
						.deleteCookies("JSESSIONID"))
				.exceptionHandling(e -> e
						.accessDeniedPage("/accessDenied"))
				.rememberMe(rememberMe -> rememberMe
						.tokenValiditySeconds(86400)
						.key("remember-me-key"));
		return http.build();
	}
}
