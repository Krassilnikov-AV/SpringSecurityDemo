/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package net.proselyte.spring.security.demo.rest;

import net.proselyte.spring.security.demo.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {
	private final List<Developer> DEVELOPERS = List.of(
		new Developer(1L, "Ivan", "Ivanov"),
		new Developer(2L, "Kolya", "Ivanov"),
		new Developer(3L, "Sergey", "Sergeev")
	);

	@GetMapping
	public List<Developer> getAll() {
		return DEVELOPERS;
	}

	@GetMapping("/{id}")
	public Developer getById(@PathVariable Long id) {
		return DEVELOPERS.stream()
			.filter(developer -> developer.getId().equals(id))
			.findFirst()
			.orElse(null);
	}
}