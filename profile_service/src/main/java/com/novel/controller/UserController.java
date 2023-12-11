package com.novel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.novel.service.ProfileService;
import com.novel.service.SequenceGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.novel.exception.UserNotFound;
import com.novel.model.UserProfile;

@RestController
@RequestMapping("/profile")
public class UserController {

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private SequenceGenerator service;

	@PostMapping("/add")
	public ResponseEntity<String> addUser(@Valid @RequestBody UserProfile userProfile) {
		userProfile.setId(service.getSequenceNumber(UserProfile.SEQUENCE_NAME));
		profileService.addNewUser(userProfile);
		return ResponseEntity.ok("User is valid");
	}

	@GetMapping("/get")
	public ResponseEntity<List<UserProfile>> findAllUsers(@RequestParam(required = false) String fullName) throws Exception{
		try {
			List<UserProfile> userProfile = new ArrayList<UserProfile>();
			if (fullName == null)
				profileService.getUsers().forEach(userProfile::add);
			else
				profileService.getByName(fullName);
			
			if (userProfile.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(userProfile, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/get/{id}")
	public ResponseEntity<?> getProfilebyid(@PathVariable("id") Integer id) throws Exception {
		UserProfile userProfile1 = profileService.getByProfileId(id);
		if (userProfile1 != null) {
			profileService.getByProfileId(id);
			return new ResponseEntity<>(userProfile1, HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	}

	@PutMapping("/get/update/{fullName}")
	public ResponseEntity<UserProfile> updateUser(@PathVariable("fullName") String fullName, @RequestBody UserProfile userProfile) throws Exception {
		UserProfile userProfile1 = profileService.getByName(fullName);
		if (userProfile1 != null) {
			UserProfile userProfile2 = profileService.updateProfile(userProfile1);
			return new ResponseEntity<>(userProfile2, HttpStatus.CREATED);
		}
		else {
			throw new UserNotFound(fullName + " not found");
	}
	}

	@DeleteMapping("/get/del/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Integer id) throws Exception {
		UserProfile userProfile1 = profileService.getByProfileId(id);
		if (userProfile1 != null) {
			profileService.deleteProfile(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			throw new UserNotFound(id + "not found");
		}	
	}



}
