package com.example.psp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@RequestMapping("/hello")
	String home() {
		return "Hello World!!!";
	}

}