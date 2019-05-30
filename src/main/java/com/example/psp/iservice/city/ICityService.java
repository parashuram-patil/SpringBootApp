package com.example.psp.iservice.city;

import java.util.List;

import com.example.psp.exception.city.CityNotFoundException;
import com.example.psp.model.citi.CreateCityModel;
import com.example.psp.model.citi.GetCityModel;

public interface ICityService {

	List<GetCityModel> findAll();

	GetCityModel save(CreateCityModel model);
	
	GetCityModel searchByName(String cityName) throws CityNotFoundException;
}