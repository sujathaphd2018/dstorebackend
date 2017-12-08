package com.drugstore.drugstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drugstore.drugstore.models.PrescriptionList;
import com.drugstore.drugstore.models.Profiles;
import com.drugstore.drugstore.repository.OrderRepository;
import com.drugstore.drugstore.repository.PrescriptionRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PrescriptionController {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	private OrderRepository orderRepository;
	
	PrescriptionController(PrescriptionRepository prescriptionRepository,OrderRepository orderRepository) {
		this.prescriptionRepository =  prescriptionRepository;
		this.orderRepository = orderRepository;
	}
	
	@RequestMapping(value="/save-prescription/{userId}", method=RequestMethod.POST)
	public PrescriptionList addPrescriptionList(@RequestBody PrescriptionList prescriptionList, @PathVariable("userId") String userId) {
		prescriptionList.setUserId(userId);
		return prescriptionRepository.save(prescriptionList);
	}
	
	@RequestMapping(value="/get-prescription-list/{userId}", method=RequestMethod.GET)
	public List<PrescriptionList> getAllProfiles( @PathVariable("userId") String userId) {
		
		return prescriptionRepository.findByUserId(userId);
	}
	
	@RequestMapping(value="/delete-list/{prescriptionListId}", method=RequestMethod.GET)
	public boolean deletePrescription(@PathVariable String prescriptionListId) {
		PrescriptionList prescriptionList = new PrescriptionList();
		prescriptionList.setId(prescriptionListId);
		prescriptionRepository.delete(prescriptionList);
		return true;
	}
	
	@RequestMapping(value="/order", method=RequestMethod.POST)
	public PrescriptionList order(@RequestBody PrescriptionList prescriptionList) {
		prescriptionList.setName("Order");
		return orderRepository.save(prescriptionList);
	}
}
