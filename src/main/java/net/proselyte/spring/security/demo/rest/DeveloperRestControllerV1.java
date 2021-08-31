/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package net.proselyte.spring.security.demo.rest;


import net.proselyte.spring.security.demo.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.*;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

	private List<Developer> DEVELOPERS = Stream.of(
		new Developer(1L, "Ivan", "Ivanov"),
		new Developer(2L, "Sergey", "Sergeev"),
		new Developer(3L, "Petr", "Petrov")
	).collect(Collectors.toList());

	@GetMapping
	public List<Developer> getAll() {
		return DEVELOPERS;
	}

	@GetMapping("/{id}")
	public Developer getById(@PathVariable Long id) {
		return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id))
			.findFirst()
			.orElse(null);
	}
}