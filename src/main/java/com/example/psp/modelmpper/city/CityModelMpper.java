package com.example.psp.modelmpper.city;

import org.modelmapper.ModelMapper;

import com.example.psp.entity.citi.CityEntity;
import com.example.psp.model.citi.CreateCityModel;

public class CityModelMpper {

	private static final ModelMapper MAPPER = new ModelMapper();

	public static CityEntity getEntity(CreateCityModel model) {

		return MAPPER.map(model, CityEntity.class);
	}

}
