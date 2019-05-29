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

	@Override
	public CityEntity save(CityEntity city) {
		
		CityEntity foundCity = searchByName(city.getName());
		if (foundCity != null) {
			foundCity.setPopulation(city.getPopulation());
			cityRepository.save(foundCity);
		} else {
			cityRepository.save(city);
		}
		
		return (foundCity != null ? foundCity : city);
	}

	@Override
	public CityEntity searchByName(String cityName) {

		CityEntity cityEntity = null;

		List<CityEntity> cityList = cityRepository.findByName(cityName);

		if (cityList.size() > 0) {
			cityEntity = cityList.get(0);
		}

		return cityEntity;
	}
}