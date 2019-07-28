package com.drkiettran.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drkiettran.mongodb.model.Carrier;
import com.drkiettran.mongodb.model.Plane;
import com.drkiettran.mongodb.repository.CarrierRepositoryImpl;
import com.drkiettran.mongodb.repository.PlaneRepositoryImpl;


@RestController
public class CarrierController {
	@Autowired
	CarrierRepositoryImpl repository;

	@RequestMapping(value = "/carrier", method = RequestMethod.GET)
	public Carrier findByTailnum(@Param("code") String code) {
		return repository.findByCode(code);
	}
}
