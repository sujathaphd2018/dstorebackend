package com.drugstore.drugstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.drugstore.drugstore.models.User;

public interface UserRepository extends MongoRepository<User, Long>{
	
	@SuppressWarnings("unchecked")
	User save(User user);
	User findByEmail(String email);
	User findById(String id);
	//User findAndUpdate(User user);
}
