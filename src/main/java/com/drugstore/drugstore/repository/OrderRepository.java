package com.drugstore.drugstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.drugstore.drugstore.models.PrescriptionList;

public interface OrderRepository extends MongoRepository<PrescriptionList, Long>{

}
