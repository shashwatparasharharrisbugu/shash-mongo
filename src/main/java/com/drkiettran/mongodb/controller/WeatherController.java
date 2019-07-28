package com.drkiettran.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drkiettran.mongodb.model.Airport;
import com.drkiettran.mongodb.repository.AirportRepositoryImpl;
import com.drkiettran.mongodb.repository.WeatherService;


@RestController
public class WeatherController {

	
	WeatherService service = new WeatherService();

	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	public String findByTailnum(@Param("location") String location) {
		System.out.println("Location"+location);
		return service.WeatherDetails(location);
	}
}
