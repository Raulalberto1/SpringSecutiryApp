package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
//@PreAuthorize("denyAll()")
public class TestAuthController {

	@GetMapping("/get")
//	@PreAuthorize("hasAuthority('READ')")
	public String helloGet() {
		return "hello GET";
	}
	
	@PostMapping("/post")
//	@PreAuthorize("hasAuthority('CREATE')")
	public String helloPost() {
		return "Hello POST";
	}
	
	@PostMapping("/put")
//	@PreAuthorize("hasAuthority('READ')")
	public String helloPut() {
		return "Hello PUT";
	}
	
	@PostMapping("/delete")
//	@PreAuthorize("hasAuthority('READ')")
	public String helloDelete() {
		return "Hello DELETE";
	}
}
