package com.example.psp.service.city;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.psp.entity.citi.CityEntity;
import com.example.psp.iservice.city.ICityService;
import com.example.psp.repository.citi.CityRepository;
import com.psp.exception.city.CityNotFoundException;

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

		CityEntity savedCity;

		try {
			CityEntity foundCity = searchByName(city.getName());
			foundCity.setPopulation(city.getPopulation());
			savedCity = cityRepository.save(foundCity);
		} catch (CityNotFoundException e) {
			savedCity = cityRepository.save(city);
		}

		return savedCity;
	}

	@Override
	public CityEntity searchByName(String cityName) throws CityNotFoundException {

		CityEntity city;

		List<CityEntity> cityList = cityRepository.findByName(cityName);

		if (cityList.size() > 0) {
			city = cityList.get(0);
		} else {
			throw new CityNotFoundException(cityName);
		}
		
		return city;
	}
}