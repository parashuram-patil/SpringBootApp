package com.example.psp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.psp.entity.CityEntity;
import com.example.psp.iservice.ICityService;

@Controller
public class CityController {

	private ICityService cityService;
	
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping("/showCities")
	public String findCities(Model model) {

		List<CityEntity> cities = (List<CityEntity>) cityService.findAll();

		model.addAttribute("cities", cities);

		return "showCities";
	}
}