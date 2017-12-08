package com.drugstore.drugstore.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.drugstore.drugstore.models.PrescriptionList;


public interface PrescriptionRepository extends MongoRepository<PrescriptionList, Long>{
	
	List<PrescriptionList> findAll();
	
	List<PrescriptionList> findByUserId(String id);
	
	@SuppressWarnings("unchecked")
	PrescriptionList save(PrescriptionList prescriptionList);
	
	
}
