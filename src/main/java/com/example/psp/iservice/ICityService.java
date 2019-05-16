package com.example.psp.iservice;

import java.util.List;

import com.example.psp.entity.CityEntity;

public interface ICityService {

	List<CityEntity> findAll();
}