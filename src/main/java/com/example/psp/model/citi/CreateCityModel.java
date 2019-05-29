package com.example.psp.model.citi;

import io.swagger.annotations.ApiModelProperty;

public class CreateCityModel {

	@ApiModelProperty(required = true, example = "MyCity")
	private String name;

	@ApiModelProperty(required = true, example = "9999")
	private int population;

	public String getName() {
		return name;
	}

	public void setName(String cityName) {
		this.name = cityName;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
}
