package com.example.psp.controller.citi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@GetMapping("/hello")
	String home() {
		return "Hello World!!!";
	}

}