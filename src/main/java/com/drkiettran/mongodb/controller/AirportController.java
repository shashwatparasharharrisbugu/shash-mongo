package com.drkiettran.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drkiettran.mongodb.model.Airport;
import com.drkiettran.mongodb.repository.AirportRepositoryImpl;

@RestController
public class AirportController {
	@Autowired
	AirportRepositoryImpl repository;

	@RequestMapping(value = "/airports", method = RequestMethod.GET)
	public Airport findByTailnum(@Param("iata") String iata) {
		return repository.findByIata(iata);
	}
}
