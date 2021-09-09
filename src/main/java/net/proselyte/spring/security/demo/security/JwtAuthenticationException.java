/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package net.proselyte.spring.security.demo.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
public class JwtAuthenticationException extends AuthenticationException {
	private HttpStatus httpStatus;
	public JwtAuthenticationException(String msg) {
		super(msg);
	}
	public JwtAuthenticationException(String msg, HttpStatus httpStatus) {
		super(msg);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}