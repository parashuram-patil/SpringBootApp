package com.example.psp.iservice.city;

import java.util.List;

import com.example.psp.entity.citi.CityEntity;
import com.example.psp.model.citi.CreateCityModel;
import com.psp.exception.city.CityNotFoundException;

public interface ICityService {

	List<CityEntity> findAll();

	CityEntity save(CreateCityModel model);
	
	CityEntity searchByName(String cityName) throws CityNotFoundException;
}