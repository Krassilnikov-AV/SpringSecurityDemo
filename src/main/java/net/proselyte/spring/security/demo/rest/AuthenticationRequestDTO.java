/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package net.proselyte.spring.security.demo.rest;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}