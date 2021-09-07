/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package net.proselyte.spring.security.demo.rest;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {

	private String email;
	private String password;
}