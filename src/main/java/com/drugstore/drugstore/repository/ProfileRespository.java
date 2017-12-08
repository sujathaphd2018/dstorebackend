package com.drugstore.drugstore.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.drugstore.drugstore.models.Profiles;

@Repository
public interface ProfileRespository extends MongoRepository<Profiles, Long> {
	
	
	List<Profiles> findAll();
	
	List<Profiles> findByUserId(String id);
	
	Profiles findByName(String name);
	
	@SuppressWarnings("unchecked")
	Profiles save(Profiles profile);

}
