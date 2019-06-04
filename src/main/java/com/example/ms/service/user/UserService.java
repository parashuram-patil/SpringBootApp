package com.example.ms.service.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.ms.exception.user.SearchUserException;
import com.example.ms.model.user.GetUsersModel;
import com.example.ms.model.user.UserModel;
import com.example.ms.service.token.TokenService;
import com.example.ms.util.RestUtil;
import com.example.psp.constants.Constants;

@Service
public class UserService {

	private RestTemplate restTemplate;
	private TokenService tokenService;

	public UserService(RestTemplate restTemplate, TokenService tokenService) {
		this.restTemplate = restTemplate;
		this.tokenService = tokenService;
	}

	public UserModel getUserByUserName(String userName) throws SearchUserException {

		String accessToken = tokenService.getToken().getAccess_token();
		HttpEntity<Object> resquestEntity = RestUtil.getResquestEntity(RestUtil.getHeaders(accessToken));
		String filter = "userName eq \"" + userName + "\"";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.MS_USERS_BASE_URL)
				.queryParam("filter", filter);
		URI url = builder.build().encode().toUri();

		ResponseEntity<GetUsersModel> response = restTemplate.exchange(url, HttpMethod.GET, resquestEntity,
				GetUsersModel.class);

		List<UserModel> usersList = response.getBody().getResources();

		if (usersList.size() == 0) {
			throw new SearchUserException(userName);
		}

		return usersList.get(0);
	}
}
