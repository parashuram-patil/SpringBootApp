package com.example.psp.controller.citi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.psp.exception.city.CityNotFoundException;
import com.example.psp.iservice.city.ICityService;
import com.example.psp.model.citi.CreateCityModel;
import com.example.psp.model.citi.GetCityModel;

import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/city")
@ApiIgnore
public class CityController {

	private ICityService cityService;

	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping("/")
	public String index() {

		return "index";
	}

	@RequestMapping(value = "/showCities", method = RequestMethod.GET, produces = "text/html")
	public String showCities(Model model) {

		List<GetCityModel> cities = (List<GetCityModel>) cityService.findAll();

		model.addAttribute("cities", cities);

		return "showCities";
	}

	@RequestMapping(value = "/saveCity", method = RequestMethod.POST, produces = "text/html")
	public String SaveCity(Model model, @RequestBody CreateCityModel city) {

		cityService.save(city);

		return showCities(model);
	}

	@RequestMapping(value = "/searchCity/{cityName}", method = RequestMethod.GET, produces = "text/html")
	public String searchCity(Model model,
			@ApiParam(value = "Name of the City", required = true) @PathVariable String cityName)
			throws CityNotFoundException {

		GetCityModel foundCity = cityService.searchByName(cityName);

		model.addAttribute("cities", new ArrayList<GetCityModel>(Arrays.asList(foundCity)));

		return "showCities";
	}

}