package com.drkiettran.mongodb.repository;

import java.util.List;
import java.util.Set;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.drkiettran.mongodb.model.Airport;
import com.drkiettran.mongodb.model.Plane;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class AirportRepositoryImpl implements AirportRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(AirportRepositoryImpl.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public <S extends Airport> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Airport> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Airport> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Airport> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airport findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Airport> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Airport entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Airport> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Airport> S findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Airport> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Airport> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Airport findByIata(String iata) {

		MongoClientURI uri = new MongoClientURI(
				"mongodb://admin:Password@cluster0-shard-00-00-popyd.mongodb.net:27017,cluster0-shard-00-01-popyd.mongodb.net:27017,cluster0-shard-00-02-popyd.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority");
		String res = "Not found";
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("airline");
		MongoCollection<Document> collection =  database.getCollection("airports");
		System.out.println(collection.count());
		Airport result = new Airport();
		Document query = new Document();
        query.put("\"iata\"", iata);
        
        System.out.println(query.toString());
		FindIterable<Document> cursor = collection.find(query);
		for (Document doc:cursor) {
				res = doc.toString();
//				System.out.println("res"+res);
//				System.out.println("doc.getString"+doc.getString("airport"));
//				Set<String> key = doc.keySet();
//				for(String k:key) {
//					System.out.println("key k "+k);
//					System.out.println("key k value"+doc.get(k));
//				}
//				System.out.println(""+doc.keySet());
//				System.out.println("doc.values()"+doc.values());
				result.setId(doc.get("_id").toString());
				result.setIata(doc.getString("\"iata\""));
				result.setAirport(doc.getString("\"airport\""));
				result.setCity(doc.getString("\"city\""));
				result.setState(doc.getString("\"state\""));
				result.setCountry(doc.getString("\"country\""));
				result.setLat(doc.getString("\"lat\""));
				result.setLongi(doc.getString("\"long\""));
				
			}

		return result;
	}

}
