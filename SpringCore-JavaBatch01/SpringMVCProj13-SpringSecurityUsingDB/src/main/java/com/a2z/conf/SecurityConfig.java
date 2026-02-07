	package com.a2z.conf;
	
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;
	
	@Configuration
	@EnableWebSecurity
	public class SecurityConfig {
		
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
			http
			.authorizeHttpRequests(auth -> 
				auth.requestMatchers("/","/login","/signup","/WEB-INF/**").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/user/**").hasRole("USER")
				.anyRequest().authenticated()
			)
			.formLogin(form -> form
					.loginPage("/login")
	                .defaultSuccessUrl("/", true)
	                
	                
	            )
			
	        .logout(logout -> logout
	                .logoutSuccessUrl("/?logout")
	                
	            );
			return http.build();
		}
		
		
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
	}
