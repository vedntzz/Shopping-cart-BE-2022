package com.novel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.novel.model.UserProfile;

public interface ProfileRepository extends MongoRepository<UserProfile, Integer>{

	public UserProfile findAllByMobileNumber(Long id);
	public UserProfile findByFullName(String name);
	
}
