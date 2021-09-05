/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package net.proselyte.spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@GetMapping("login")
	public String getLoginPage() {
		return "login";
	}
	@GetMapping("/success")
	public String getSuccessPage() {
		return "success";
	}
}