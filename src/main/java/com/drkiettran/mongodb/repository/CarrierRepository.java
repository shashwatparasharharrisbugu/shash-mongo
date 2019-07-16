package com.drkiettran.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.drkiettran.mongodb.model.Carrier;

public interface CarrierRepository extends MongoRepository<Carrier, String> {

	@Query("{iata:'?0'}")
	Carrier findByIata(@Param("iata") String iata);

}
