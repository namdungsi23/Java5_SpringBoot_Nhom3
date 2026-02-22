package poly.edu.ASSM.Services.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import poly.edu.ASSM.component.OAuth2LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
	
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/**",
									 "/login/**", 
									 "/error",
									 "/css/**",
									 "/js/**",
									 "/images/**").permitAll()
					.anyRequest().authenticated()
					)
			.oauth2Login(oauth -> oauth
					.successHandler(oAuth2LoginSuccessHandler))
			.exceptionHandling(ex -> ex
					.authenticationEntryPoint((request, response, authException) -> {
						response.sendRedirect("/");
					})
					.accessDeniedHandler((request, response, accessDeniedException) -> {
						response.sendRedirect("/");
					})
				);
		return http.build();
	}
}
