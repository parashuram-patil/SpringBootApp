package com.example.psp.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.example.ms.model.asset.SearchAssetsByNameResponseModel;
import com.example.psp.entity.citi.CityEntity;
import com.example.psp.model.citi.CreateCityModel;
import com.examples.ms.util.RestUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	private static final String message = "City :msg not found";

	public static void main(String[] args) throws Exception {
		System.out.println("**********	Test	**********");

		// replaceStaticString();
		// testModelMapper();
		// printMediaType();
		//testTooManyFilesOpened();
		deserialiseObject();

	}

	private static void deserialiseObject() throws JsonParseException, JsonMappingException, IOException {

		String josnString = "{\"_embedded\":{\"assets\":[{\"assetId\":\"891491f9deac4249bf72cb47697cd059\",\"tenantId\":\"psdigdev\",\"name\":\"PSP_Demo_Agent\",\"etag\":1,\"externalId\":\"\",\"t2Tenant\":null,\"subTenant\":null,\"description\":\"\",\"timezone\":\"Europe/Berlin\",\"twinType\":\"performance\",\"parentId\":\"609c937e06094bd7adb9cbd6d422416a\",\"typeId\":\"core.mclib\",\"location\":{\"country\":\"United Kingdom\",\"region\":null,\"locality\":\"Warwick\",\"streetAddress\":\"Warwick Technology Park\",\"postalCode\":\"CV34 6DA\",\"longitude\":-1.563977,\"latitude\":52.274048},\"fileAssignments\":[],\"variables\":[],\"aspects\":[{\"name\":\"connectivityStatus\",\"variables\":[{\"name\":\"connected\",\"value\":\"false\"}]}],\"locks\":[{\"service\":\"AgentManagement\",\"reason\":\"Agent is onboarded, agent cannot be deleted. Only offboarded agents can be deleted.\",\"reasonCode\":\"agentmanagement.agent.onboarded\",\"_links\":{\"self\":{\"href\":\"https://gateway.eu1.mindsphere.io/api/assetmanagement/v3/assets/891491f9deac4249bf72cb47697cd059/locks/62980418fdd441dcb8a6660c6feff5ff\"}},\"id\":\"62980418fdd441dcb8a6660c6feff5ff\"}],\"deleted\":null,\"_links\":{\"self\":{\"href\":\"https://gateway.eu1.mindsphere.io/api/assetmanagement/v3/assets/891491f9deac4249bf72cb47697cd059\"},\"aspects\":{\"href\":\"https://gateway.eu1.mindsphere.io/api/assetmanagement/v3/assets/891491f9deac4249bf72cb47697cd059/aspects\"},\"variables\":{\"href\":\"https://gateway.eu1.mindsphere.io/api/assetmanagement/v3/assets/891491f9deac4249bf72cb47697cd059/variables\"},\"location\":{\"href\":\"https://gateway.eu1.mindsphere.io/api/assetmanagement/v3/assets/609c937e06094bd7adb9cbd6d422416a/location\"},\"parent\":{\"href\":\"https://gateway.eu1.mindsphere.io/api/assetmanagement/v3/assets/609c937e06094bd7adb9cbd6d422416a\"}}}]},\"_links\":{\"self\":{\"href\":\"https://gateway.eu1.mindsphere.io/api/assetmanagement/v3/assets?filter=%25257B%252522name%252522:%25257B%252522eq%252522:%252522PSP_Demo_Agent%252522%25257D%25257D&page=0&size=10&sort=name,asc\"}},\"page\":{\"size\":10,\"totalElements\":1,\"totalPages\":1,\"number\":0}}";
		ObjectMapper mapper = new ObjectMapper();
		SearchAssetsByNameResponseModel model = mapper.readValue(josnString, SearchAssetsByNameResponseModel.class);
		String country = model.get_embedded().getAssets().get(0).getLocation().getCountry();
		System.out.println(country);
	}

	private static void testTooManyFilesOpened() throws IOException {
		while (true) {
			File crcfile=new File("src/main/resources/test/"+ UUID.randomUUID().toString() + ".tmp");
			boolean createNewFile = crcfile.createNewFile();
			System.out.println(createNewFile);
			FileReader in = new FileReader(crcfile);
			BufferedReader br = new BufferedReader(in);
			String strLine;
			while ((strLine = br.readLine()) != null) {
				//System.out.println("---> " + strLine);
			}
			in.close();
			boolean delete = crcfile.delete();
			System.err.println(crcfile.delete() + "::" + crcfile.exists());
			br.close();
		}
	}

	private static void printMediaType() {

		HttpHeaders createHeaders = RestUtil.getHeaders("aaaa", "aaaa", MediaType.APPLICATION_FORM_URLENCODED);
		System.err.println(createHeaders.toString());

	}

	private static void testModelMapper() {
		CreateCityModel cityModel = new CreateCityModel();
		cityModel.setName("a");
		cityModel.setPopulation(1);
		CityEntity cityEntity = new ModelMapper().map(cityModel, CityEntity.class);
		if (!cityEntity.getName().equals(cityModel.getName()))
			System.err.println("Error in mapping City Name");
		if (!(cityEntity.getPopulation() == cityModel.getPopulation()))
			System.err.println("Error in mapping City Population");
	}

	private static void replaceStaticString() {
		System.out.println(message.replace(":msg", "XXX"));
		System.out.println(message);
		System.out.println(message.replace(":msg", "YYYY"));
		System.out.println(message);
	}

}
