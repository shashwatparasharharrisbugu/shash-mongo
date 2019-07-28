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
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class PlaneRepositoryImpl implements PlaneRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(PlaneRepositoryImpl.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public <S extends Plane> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plane> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plane> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Plane> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Plane> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Plane> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Plane> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Plane> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Plane> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plane findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Plane> findAll(Iterable<String> ids) {
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
	public void delete(Plane entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Plane> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Plane> S findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Plane> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Plane> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Plane> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Plane findByTailnum(String tailnum) {
//		LOGGER.info("tailnum: {}", tailnum);
//		
//		Query query = new Query();
//		query.addCriteria(Criteria.where("tailnum").is(tailnum));
//
//		Plane plane = mongoTemplate.findOne(query, Plane.class);
//		return plane;
		MongoClientURI uri = new MongoClientURI(
				"mongodb://admin:Password@cluster0-shard-00-00-popyd.mongodb.net:27017,cluster0-shard-00-01-popyd.mongodb.net:27017,cluster0-shard-00-02-popyd.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority");
		String res = "Not found";
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("airline");
		MongoCollection<Document> collection = database.getCollection("planes");
		System.out.println(collection.count());
		Plane result = new Plane();
		Document query = new Document();
		query.put("tailnum", tailnum);

		System.out.println(query.toString());
		
	//	FindIterable<Document> cursor = collection.find(query);
		FindIterable<Document> cursor = collection.find(query);
		for (Document doc : cursor) {
			res = doc.toString();
//			System.out.println("res"+res);
//			System.out.println("doc.getString"+doc.getString("airport"));
//			Set<String> key = doc.keySet();
//			for(String k:key) {
//				System.out.println("key k "+k);
//				System.out.println("key k value"+doc.get(k));
//			}
//			break;
			System.out.println("res" + res);
			result.setId(doc.get("_id").toString());
			result.setTailnum((doc.getString("tailnum")));
			result.setAircraft_type((doc.getString("aircraft_type")));
			result.setEngine_type(doc.getString("engine_type"));
			result.setId(doc.getString("country"));
			result.setIssue_date((doc.getString("issue_date")));
			result.setManufacturer((doc.getString("manufacturer")));
			result.setModel(doc.getString("model"));
			result.setStatus(doc.getString("status"));
			result.setType(doc.getString("type"));
			result.setYear(doc.getString("year"));
		}

		return result;
	}

}
