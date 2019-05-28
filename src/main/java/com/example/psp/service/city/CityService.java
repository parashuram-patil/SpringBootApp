package com.example.psp.service.city;

import java.util.List;
import java.util.Optional;

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

	@Override
	public CityEntity save(CityEntity cityEntity) {

		return cityRepository.save(cityEntity);

	}

	@Override
	public CityEntity findbyName(String cityName) {

		CityEntity cityEntity = null;
		
		List<CityEntity> cityList = cityRepository.findByName(cityName);
		
		if(cityList.size() > 0) {
			cityEntity = cityList.get(0);
		}
		
		return cityEntity;
	}

}