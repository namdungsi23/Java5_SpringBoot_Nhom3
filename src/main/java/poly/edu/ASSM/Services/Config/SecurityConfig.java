package poly.edu.ASSM.Services.Config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import poly.edu.ASSM.component.CustomSuccessHandler;
import poly.edu.ASSM.component.OAuth2LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
	
	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	/*
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/admin/**").permitAll()
					//.requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/**",
									 "/login/**", 
									 "/error",
									 "/css/**",
									 "/js/**",
									 "/images/**").permitAll()
					.anyRequest().authenticated()
			)
			//OAuth2 Login
			.oauth2Login(oauth -> oauth
					.successHandler(oAuth2LoginSuccessHandler))
			//Exception Handling
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
	*/
	
	/*
	@Bean
    public PasswordEncoder getPasswordEncoder() {
    	return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    */
	
	/*
	@Bean
	public PasswordEncoder passwordEncoder() {
	    String idForEncode = "bcrypt";

	    Map<String, PasswordEncoder> encoders = new HashMap<>();
	    encoders.put("bcrypt", new BCryptPasswordEncoder());

	    return new DelegatingPasswordEncoder(idForEncode, encoders);
	}
	*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(auth -> auth
		        .requestMatchers("/admin/**").hasRole("ADMIN")
	            // Public resources
	            .requestMatchers(
	            	"/",
	            	"/home",
	            	"/product",
	                "/login", 
	                "/error",
	                "/css/**",
	                "/js/**",
	                "/images/**"
	            ).permitAll()
	            .anyRequest().authenticated()
	        )
	        // FORM LOGIN
	        .formLogin(form -> form
	        	//.disable()
	            .loginPage("/")               
	            .loginProcessingUrl("/login/validate")     
	            //.defaultSuccessUrl("/product", true)
	            .successHandler(customSuccessHandler)
	            .failureUrl("/") 
	            .usernameParameter("username")
	            .passwordParameter("pwd")
	        )
	      //OAuth2 Login
			.oauth2Login(oauth -> oauth
					.successHandler(oAuth2LoginSuccessHandler))
	        // EXCEPTION HANDLING
	        .exceptionHandling(ex -> ex
	            .authenticationEntryPoint((req, res, e) -> {
	                res.sendRedirect("/");
	            })
	            .accessDeniedHandler((req, res, e) -> {
	                res.sendRedirect("/");
	            })
	        );

	    return http.build();
	}
	
}
