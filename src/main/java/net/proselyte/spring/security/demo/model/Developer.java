/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package net.proselyte.spring.security.demo.model;


import lombok.*;

@Data
@AllArgsConstructor
public class Developer {

	private Long id;
	private String firstname;
	private String lastname;
}