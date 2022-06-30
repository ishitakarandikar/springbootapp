/**package com.mycompany;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.mycompany.user.User;
import com.mycompany.user.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
 public class UserRepositoryTests {

	@Autowired private UserRepository repo;
	
	@Test
	public void testAddNew()
	{
		User user = new User();
		
		user.setEmail("ishitakarandikar@gmail.com");
		user.setPassword("password");
		user.setFirstname("ishita");
		user.setLastname("karandikar");
		
		User savedUser = repo.save(user);
		
		Assertions.assertThat(savedUser).isNotNull();
		Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testlistAll()
	{
		Iterable<User> users = repo.findAll();
		Assertions.assertThat(users).hasSizeGreaterThan(0);
		
		for(User user : users)
		{
			System.out.println(users);
		}
	}
	
	@Test
	public void testUpdate()
	{
		Integer userId= 1;
		Optional<User> optionalUser = repo.findById(userId);
		User user = optionalUser.get();
		user.setPassword("hello");
		repo.save(user);

		User updatedUser = repo.findById(userId).get();
		Assertions.assertThat(updatedUser.getPassword()).isEqualTo("hello");
	}
	
	@Test
	public void testDelete()
	{
		Integer userId=2;
	    repo.deleteById(userId);
	    
	    Optional<User> optionalUser = repo.findById(userId);
	    Assertions.assertThat(optionalUser).isNotPresent();
	}
}
*/