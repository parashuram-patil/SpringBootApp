package com.example.psp.city.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.psp.citi.entity.CityEntity;
import com.example.psp.citi.repository.CityRepository;
import com.example.psp.city.iservice.ICityService;

@Service
public class CityService implements ICityService {

	private CityRepository cityRepository;

	public CityService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public List<CityEntity> findAll() {

		List<CityEntity> cities = (List<CityEntity>) cityRepository.findAll();

		return cities;
	}

}