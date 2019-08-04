package com.drkiettran.mongodb;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.drkiettran.mongodb.model.Airport;
import com.drkiettran.mongodb.model.Carrier;
import com.drkiettran.mongodb.model.Plane;
import com.drkiettran.mongodb.repository.AirportRepositoryImpl;
import com.drkiettran.mongodb.repository.CarrierRepositoryImpl;
import com.drkiettran.mongodb.repository.PlaneRepositoryImpl;
import com.drkiettran.mongodb.repository.WeatherService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void airportSuccessTestCase() {
		Airport airport = new Airport();
		AirportRepositoryImpl impl = new AirportRepositoryImpl();
		airport= impl.findByIata("\"00M\"");
		Assert.assertEquals(airport.getIata(), "\"00M\"");
		Assert.assertEquals(airport.getAirport(),"\"Thigpen \"");
		Assert.assertEquals(airport.getCity(), "\"Bay Springs\"");
		Assert.assertEquals(airport.getState(),"\"MS\"");
		Assert.assertEquals(airport.getCountry(), "\"USA\"");
		Assert.assertEquals(airport.getLongi(), "-89.23450472");
		Assert.assertEquals(airport.getLat(), "31.95376472");
	}

	@Test
	public void airportFailueTestCase() {
		Airport airport = new Airport();
		AirportRepositoryImpl impl = new AirportRepositoryImpl();
		airport= impl.findByIata("\"00M\"");
		Assert.assertNotSame(airport.getIata(), "Failure");;
	}

	@Test
	public void carrierSuccessTestCase() {
		
		CarrierRepositoryImpl impl = new CarrierRepositoryImpl();
		Carrier carrier = new Carrier();
		carrier = impl.findByCode("\"02Q\"");
		Assert.assertEquals(carrier.getDescription(), "\"02Q\"");
		Assert.assertEquals(carrier.getCode(), "\"Titan Airways\"");
	}

	@Test
	public void carrierFailureTestCase() {

		CarrierRepositoryImpl impl = new CarrierRepositoryImpl();
		Carrier carrier = new Carrier();
		carrier = impl.findByCode("\"02Q\"");
		Assert.assertNotSame(carrier.getCode(), "\"02B\"");
	}

	@Test
	public void planeSuccessTestCase() {
		PlaneRepositoryImpl impl = new PlaneRepositoryImpl();
		Plane plane = new Plane();
		plane = impl.findByTailnum("N11150");
		Assert.assertEquals(plane.getAircraft_type(), "Fixed Wing Multi-Engine");
		Assert.assertEquals(plane.getEngine_type(), "Turbo-Fan");
		Assert.assertEquals(plane.getIssue_date(), "10/21/2003");
		Assert.assertEquals(plane.getManufacturer(), "EMBRAER");
		Assert.assertEquals(plane.getModel(), "EMB-145XR");
		Assert.assertEquals(plane.getStatus(), "Valid");
		Assert.assertEquals(plane.getTailnum(), "N11150");
		Assert.assertEquals(plane.getType(), "Corporation");
		Assert.assertEquals(plane.getYear(), "2003");
		
	}

	@Test
	public void planeFailureTestCase() {
		
		PlaneRepositoryImpl impl = new PlaneRepositoryImpl();
		Plane plane = new Plane();
		plane = impl.findByTailnum("N11150");
		Assert.assertNotSame(plane.getAircraft_type(), "Fixed ngine");
	}

	@Test
	public void weatherSuccessTestCase() {
		WeatherService ws = new WeatherService();
		String weatherStatus= ws.WeatherDetails("London,uk");
		Assert.assertTrue(weatherStatus.contains("temp_max"));
	}

	@Test
	public void weatherFailureTestCase() {
		WeatherService ws = new WeatherService();
		String weatherStatus= ws.WeatherDetails("myhometown");
		Assert.assertFalse(weatherStatus.contains("temp_max"));
	}

}
