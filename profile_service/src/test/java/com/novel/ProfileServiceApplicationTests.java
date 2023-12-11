package com.novel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.novel.model.UserProfile;
import com.novel.repository.ProfileRepository;
import com.novel.service.ProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProfileServiceApplicationTests {

	@Autowired
	private ProfileService profileService;
	
	@MockBean
	private ProfileRepository profileRepository;
	
//	@Test
//	public void addProfileTest() {
//		UserProfile user = new UserProfile(111, "Vedant", "vs@gmail.com", "888888888", "Student", "1/5/2000", "Male", "USER", "abc");
//		when(profileRepository.save(user)).thenReturn(user);
//		assertEquals(user, profileService.addNewUser(user));
//	}

	@Test
	public void deleteByIdTest() {
		Integer id = 1;
		profileService.deleteProfile(id);
		verify(profileRepository,times(1)).deleteById(id);
	}
	
	@Test
	public void getProfiles() {
		when(profileRepository.findAll()).thenReturn(Stream.of(new UserProfile(111, "Novel", "nm@gmail.com", "1234567898", "Developer", "7/9/1999", "Male", "ADMIN", "XYZ")).collect(Collectors.toList()));
		assertEquals(1, profileService.getUsers().size());
	}
}
