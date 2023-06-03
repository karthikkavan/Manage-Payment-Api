package com.ak.config;

import org.aspectj.weaver.ast.Var;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(auth->auth.requestMatchers("/payments/**")
				.permitAll().anyRequest().authenticated());
		http.httpBasic();
		http.csrf().disable();
		return http.build();
				
	}
	
	@Bean
	public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
		var authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		return new ProviderManager(authenticationProvider);
		
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user= User.withUsername("karthik")
				.password("{noop}111")
				.authorities("read")
				.roles("USER")
				.build();
		
		UserDetails user1= User.withUsername("kavan")
				.password("{noop}111")
				.authorities("read")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, user1);
	}
}
