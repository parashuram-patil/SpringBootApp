package com.example.psp.city.iservice;

import java.util.List;

import com.example.psp.citi.entity.CityEntity;

public interface ICityService {

	List<CityEntity> findAll();
}