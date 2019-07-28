package com.drkiettran.mongodb.repository;

import java.util.List;
import java.util.Set;

import org.bson.Document;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.drkiettran.mongodb.model.Carrier;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CarrierRepositoryImpl implements CarrierRepository {

	@Override
	public <S extends Carrier> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carrier> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carrier> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Carrier> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Carrier> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Carrier> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Carrier> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Carrier> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Carrier> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrier findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Carrier> findAll(Iterable<String> ids) {
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
	public void delete(Carrier entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Carrier> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Carrier> S findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Carrier> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Carrier> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Carrier> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Carrier findByCode(String code) {
		MongoClientURI uri = new MongoClientURI(
				"mongodb://admin:Password@cluster0-shard-00-00-popyd.mongodb.net:27017,cluster0-shard-00-01-popyd.mongodb.net:27017,cluster0-shard-00-02-popyd.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority");
		String res = "Not found";
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("airline");
		MongoCollection<Document> collection = database.getCollection("carriers");
		System.out.println(collection.count());
		Carrier result = new Carrier();
		Document query = new Document();
		query.put("Code", code);

		System.out.println(query.toString());
		FindIterable<Document> cursor = collection.find(query);
		for (Document doc : cursor) {

			res = doc.toString();
			result.setDescription(doc.getString("Code"));
			result.setCode(doc.getString("Description"));

		}
		return result;
	}

}
