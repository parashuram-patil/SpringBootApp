package com.example.psp.main;

import static org.junit.Assert.assertEquals;

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
		assertEquals(cityEntity.getName(), cityModel.getName());
		assertEquals(cityEntity.getPopulation(), cityModel.getPopulation());
	}

	private static void replaceStaticString() {
		System.out.println(message.replace(":msg", "XXX"));
		System.out.println(message);
		System.out.println(message.replace(":msg", "YYYY"));
		System.out.println(message);
	}

}
