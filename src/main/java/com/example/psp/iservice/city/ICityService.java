package com.example.psp.iservice.city;

import java.util.List;

import com.example.psp.entity.citi.CityEntity;
import com.psp.exception.city.CityNotFoundException;

public interface ICityService {

	List<CityEntity> findAll();

	CityEntity save(CityEntity cityEntity);
	
	CityEntity searchByName(String cityName) throws CityNotFoundException;
}