package com.example.psp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.psp.entity.CityEntity;
import com.example.psp.iservice.ICityService;
import com.example.psp.repository.CityRepository;

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