package com.example.psp.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.example.psp.entity.citi.CityEntity;
import com.example.psp.model.citi.CreateCityModel;
import com.examples.ms.util.RestUtil;

public class Test {

	private static final String message = "City :msg not found";

	public static void main(String[] args) throws Exception {
		System.out.println("**********	Test	**********");

		// replaceStaticString();
		// testModelMapper();
		// printMediaType();
		testTooManyFilesOpened();

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
