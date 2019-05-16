package com.example.psp.controller.citi;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.psp.entity.citi.CityEntity;
import com.example.psp.iservice.city.ICityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
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

	@ApiOperation(value = "View a list of available products", response = CityEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved All cities"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/showCities")
	@RequestMapping(value = "/showCities", method = RequestMethod.GET, produces = "text/html")
	public String findCities(Model model) {

		List<CityEntity> cities = (List<CityEntity>) cityService.findAll();

		model.addAttribute("cities", cities);

		return "showCities";
	}
}