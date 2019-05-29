package com.example.psp.controller.citi;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.psp.entity.citi.CityEntity;
import com.example.psp.iservice.city.ICityService;
import com.example.psp.model.citi.CreateCityModel;
import com.psp.exception.ErrorResponse;
import com.psp.exception.city.CityNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/city/m2m")
@Api(tags = { "City" }, description = "Know your city")
public class CityRestController {

	private ICityService cityService;

	public CityRestController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@ApiOperation(value = "", hidden = true)
	@GetMapping("/")
	public String index() {

		return "City M2M API's";
	}

	@ApiOperation(value = "View all Cities along with its population")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved all cities", response = CityEntity.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/showCities", method = RequestMethod.GET)
	public List<CityEntity> showCities(Model model) {

		return cityService.findAll();
	}

	@ApiOperation(value = "Save City, creates if not present otherwise updates population")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully saved the City and retrieved all cities", response = CityEntity.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/saveCity", method = RequestMethod.POST)
	public CityEntity SaveCity(Model model, @RequestBody CreateCityModel city) {

		return cityService.save(city);
	}

	@ApiOperation(value = "Search City by its name")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved City with given name", response = CityEntity.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorResponse.class) })
	@RequestMapping(value = "/searchCity/{cityName}", method = RequestMethod.GET)
	public CityEntity searchCity(Model model,
			@ApiParam(value = "Name of the City", required = true) @PathVariable String cityName)
			throws CityNotFoundException {

		return cityService.searchByName(cityName);
	}

}