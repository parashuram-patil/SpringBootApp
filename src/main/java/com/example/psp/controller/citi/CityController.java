package com.example.psp.controller.citi;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.psp.entity.citi.CityEntity;
import com.example.psp.iservice.city.ICityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(tags = { "City" }, description = "Know your city")
public class CityController {

	private ICityService cityService;

	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}

	@ApiOperation(value = "", hidden = true)
	@GetMapping("/")
	public String index() {

		return "index";
	}

	@ApiOperation(value = "View all Cities along with its population", response = CityEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved All cities"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/showCities", method = RequestMethod.GET, produces = "text/html")
	public String findCities(Model model) {

		List<CityEntity> cities = (List<CityEntity>) cityService.findAll();

		model.addAttribute("cities", cities);

		return "showCities";
	}

	@RequestMapping(value = "/saveCity", method = RequestMethod.POST, produces = "text/html")
	public String SaveCity(Model model, @RequestBody CityEntity city) {

		CityEntity foundCity = cityService.findbyName(city.getName());
		if (foundCity != null) {
			foundCity.setPopulation(city.getPopulation());
			cityService.save(foundCity);
		} else {
			cityService.save(city);
		}

		return findCities(model);
	}
}