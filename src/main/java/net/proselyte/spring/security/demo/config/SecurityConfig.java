/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package net.proselyte.spring.security.demo.config;

import net.proselyte.spring.security.demo.model.Role;
import net.proselyte.spring.security.demo.security.JwtConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	private final UserDetailsService userDetailsService;

//	@Autowired
//	public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
//		this.userDetailsService = userDetailsService;
//	}

	private final JwtConfigurer jwtConfigurer;

	public SecurityConfig(JwtConfigurer jwtConfigurer) {
		this.jwtConfigurer = jwtConfigurer;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/api/v1/auth/login").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.apply(jwtConfigurer);
	}


//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(daoAuthenticationProvider());
//	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
			User.builder().username("admin")
				.password(passwordEncoder().encode("admin"))
				.authorities(Role.ADMIN.getAuthorities())
				.build(),
			User.builder().username("user")
				.password(passwordEncoder().encode("user"))
				.authorities(Role.USER.getAuthorities())
				.build()
		);
	}

	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

//	@Bean
//	protected DaoAuthenticationProvider daoAuthenticationProvider() {
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//		return daoAuthenticationProvider;
//	}
}