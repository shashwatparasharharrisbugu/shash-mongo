package com.drkiettran.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.drkiettran.mongodb.model.Airport;

@Repository
public interface AirportRepository extends MongoRepository<Airport, String> {

	@Query("{iata:'?0'}")
	Airport findByIata(@Param("iata") String iata);

}
