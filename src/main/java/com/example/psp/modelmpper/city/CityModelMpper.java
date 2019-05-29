package com.example.psp.modelmpper.city;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.example.psp.entity.citi.CityEntity;
import com.example.psp.model.citi.CreateCityModel;
import com.example.psp.model.citi.GetCityModel;

public class CityModelMpper {

	private static final ModelMapper MAPPER = new ModelMapper();

	public static CityEntity getEntity(CreateCityModel model) {

		return MAPPER.map(model, CityEntity.class);
	}

	public static GetCityModel getModel(CityEntity entity) {

		return MAPPER.map(entity, GetCityModel.class);
	}

	public static List<GetCityModel> getModel(List<CityEntity> entities) {

		return MAPPER.map(entities, List.class);
	}
}
