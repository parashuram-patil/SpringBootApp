package com.example.psp.iservice.city;

import java.util.List;

import com.example.psp.entity.citi.CityEntity;

public interface ICityService {

	List<CityEntity> findAll();
}