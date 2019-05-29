package com.example.psp.service.city;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.psp.entity.citi.CityEntity;
import com.example.psp.iservice.city.ICityService;
import com.example.psp.model.citi.CreateCityModel;
import com.example.psp.model.citi.GetCityModel;
import com.example.psp.modelmpper.city.CityModelMpper;
import com.example.psp.repository.citi.CityRepository;
import com.psp.exception.city.CityNotFoundException;

@Service
public class CityService implements ICityService {

	private CityRepository cityRepository;

	public CityService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public List<GetCityModel> findAll() {

		List<CityEntity> cities = (List<CityEntity>) cityRepository.findAll();

		return CityModelMpper.getModel(cities);
	}

	@Override
	public GetCityModel save(CreateCityModel model) {

		CityEntity savedCity;

		try {
			CityEntity foundCity = searchByName(model.getName());
			foundCity.setPopulation(model.getPopulation());
			savedCity = cityRepository.save(foundCity);
		} catch (CityNotFoundException e) {
			savedCity = cityRepository.save(CityModelMpper.getEntity(model));
		}

		return CityModelMpper.getModel(savedCity);
	}

	@Override
	public GetCityModel searchByName(String cityName) throws CityNotFoundException {

		GetCityModel city;

		List<CityEntity> cityList = cityRepository.findByName(cityName);

		if (cityList.size() > 0) {
			city = CityModelMpper.getModel(cityList.get(0));
		} else {
			throw new CityNotFoundException(cityName);
		}

		return city;
	}
}