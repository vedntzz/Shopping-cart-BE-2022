package com.novel.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserProfile {
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private int id;
	
	@NotBlank(message = "Name is mandatory")
	private String fullName;
	
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@NotBlank(message = "Number is mandatory")
	private String mobileNumber;
	
	@NotBlank(message = "About is mandatory")
	private String about;
	
	@NotBlank(message = "DOB is mandatory")
	private String dateOfBirth;
	
	@NotBlank(message = "Gender is mandatory")
	private String gender;
	
	@NotBlank(message = "Role is mandatory")
	private String role;
	
	@NotBlank(message = "Password is mandatory")
	private String password;
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserProfile(int id, String fullName, String email, String mobileNumber, String about, String dateOfBirth,
					  String gender, String role, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.about = about;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.role = role;
		this.password = password;
	}



}
