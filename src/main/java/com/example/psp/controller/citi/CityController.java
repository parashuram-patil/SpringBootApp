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

	@ApiOperation(value = "View all Cities along with its population")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved all cities"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/showCities", method = RequestMethod.GET, produces = "text/html")
	public String showCities(Model model) {

		List<CityEntity> cities = (List<CityEntity>) cityService.findAll();

		model.addAttribute("cities", cities);

		return "showCities";
	}

	@ApiOperation(value = "Save City, creates if not present otherwise updates population")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully saved the City and retrieved all cities"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/saveCity", method = RequestMethod.POST, produces = "text/html")
	public String SaveCity(Model model, @RequestBody CreateCityModel city) {

		cityService.save(city);

		return showCities(model);
	}

	@ApiOperation(value = "Search City by its name")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved City with given name"),
			// @ApiResponse(code = 200, message = "Successfully retrieved City with given name", response = CityEntity.class, examples = @Example(value = @ExampleProperty(value = "{\"id\":1,\"name\":\"MyCity\",\"population\":9999}", mediaType = "application/json"))),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorResponse.class) })
	@RequestMapping(value = "/searchCity/{cityName}", method = RequestMethod.GET, produces = "text/html")
	public String searchCity(Model model,
			@ApiParam(value = "Name of the City", required = true) @PathVariable String cityName)
			throws CityNotFoundException {

		CityEntity foundCity = cityService.searchByName(cityName);

		model.addAttribute("cities", new ArrayList<CityEntity>(Arrays.asList(foundCity)));

		return "showCities";
	}

}