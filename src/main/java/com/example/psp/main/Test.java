package com.example.psp.main;

import org.modelmapper.ModelMapper;

import com.example.psp.entity.citi.CityEntity;
import com.example.psp.model.citi.CreateCityModel;

public class Test {

	private static final String message = "City :msg not found";

	public static void main(String[] args) {
		System.out.println("**********	Test	**********");

		// replaceStaticString();
		testModelMapper();

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
