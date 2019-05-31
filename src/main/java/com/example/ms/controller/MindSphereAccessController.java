package com.example.ms.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms.model.TokenResponseModel;
import com.example.ms.service.token.GetToken;

@RestController
@RequestMapping("/ms")
public class MindSphereAccessController {

	private GetToken getToken;

	public MindSphereAccessController(GetToken getToken) {
		this.getToken = getToken;
	}

	@RequestMapping(value = "/getToken", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
	public TokenResponseModel getToken() {

		return getToken.getToken();
	}
}
