package com.example.psp.iservice.city;

import java.util.List;

import com.example.psp.model.citi.CreateCityModel;
import com.example.psp.model.citi.GetCityModel;
import com.psp.exception.city.CityNotFoundException;

public interface ICityService {

	List<GetCityModel> findAll();

	GetCityModel save(CreateCityModel model);
	
	GetCityModel searchByName(String cityName) throws CityNotFoundException;
}