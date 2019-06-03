package com.example.ms.service.asset;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.ms.model.asset.SearchAssetsByNameResponseModel;
import com.example.ms.service.token.TokenService;
import com.example.psp.constants.Constants;
import com.examples.ms.util.RestUtil;

@Service
public class AssetService {

	private RestTemplate restTemplate;
	private TokenService tokenService;

	public AssetService(RestTemplate restTemplate, TokenService tokenService) {
		this.restTemplate = restTemplate;
		this.tokenService = tokenService;
	}
	
	public SearchAssetsByNameResponseModel getAssetsByName(String assetName) throws Exception {
		
		String accessToken = tokenService.getToken().getAccess_token();
		HttpEntity<Object> resquestEntity = RestUtil.getResquestEntity(RestUtil.getHeaders(accessToken));
		String filter = "{\"name\":{\"eq\":\":" + assetName + "\"}}";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.MS_ASSSETS_BASE_URL)
				.queryParam("filter", filter);
		URI url = builder.build().encode().toUri();

		ResponseEntity<SearchAssetsByNameResponseModel> response = restTemplate.exchange(url, HttpMethod.GET,
				resquestEntity, SearchAssetsByNameResponseModel.class);

		return response.getBody();
		
		/*String accessToken = tokenService.getToken().getAccess_token();
		String filter = "?filter={\"name\":{\"eq\":\"" + assetName + "\"}}";
		String url = Constants.MS_ASSSETS_BASE_URL + filter;
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
		  .url(url)
		  .get()
		  .addHeader("Authorization", "Bearer " + accessToken)
		  .build();

		try {
			Response response = client.newCall(request).execute();
			return new ObjectMapper().readValue(response.body().byteStream(), SearchAssetsByNameResponseModel.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new SearchAssetExceptionException(e.getMessage());
		}*/
	}
}
