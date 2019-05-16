package com.example.psp.service.city;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.psp.entity.citi.CityEntity;
import com.example.psp.iservice.city.ICityService;
import com.example.psp.repository.citi.CityRepository;

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