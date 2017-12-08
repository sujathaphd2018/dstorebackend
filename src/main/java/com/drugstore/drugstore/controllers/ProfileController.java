package com.drugstore.drugstore.controllers;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.drugstore.drugstore.models.Profiles;
import com.drugstore.drugstore.repository.ProfileRespository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProfileController {
	
	@Autowired
	private ProfileRespository profileRespository;
	
	public ProfileController(ProfileRespository profileRespository) {
		this.profileRespository = profileRespository;
	}
	
	@RequestMapping(value="/save-profiles/{userId}", method=RequestMethod.POST)
	public Profiles addProfile(@RequestBody Profiles profile, @PathVariable("userId") String userId) {
		profile.setUserId(userId);
		return profileRespository.save(profile);
	}
	@RequestMapping(value="/get-profiles/{userId}", method=RequestMethod.GET)
	public List<Profiles> getAllProfiles(@PathVariable("userId") String userId) {
		return profileRespository.findByUserId(userId);
	}

}
