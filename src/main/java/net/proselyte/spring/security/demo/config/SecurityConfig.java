/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package net.proselyte.spring.security.demo.config;

import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import net.proselyte.spring.security.demo.model.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers(HttpMethod.GET, "/api/**").hasAnyRole(Role.ADMIN.name(), Role.USER.name())
			.antMatchers(HttpMethod.POST, "/api/**").hasRole(Role.ADMIN.name())
			.antMatchers(HttpMethod.DELETE, "/api/**").hasRole(Role.ADMIN.name())
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
			User.builder().username("admin")
				// Use without encode first
				.password(passwordEncoder().encode("admin"))
				.roles(Role.ADMIN.name())
				.build(),
			User.builder().username("user")
				// Use without encode first
				.password(passwordEncoder().encode("user"))
				.roles(Role.USER.name())
				.build()
		);
		// Go to UserDetailsServiceImpl - InMemory
	}

	@Bean
	protected PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(12);
	}
}