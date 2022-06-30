package com.mycompany.user;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired private UserRepository repo;
	
	public 	List<User> listAll()
	{
		return (List<User>)repo.findAll();
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}
	
	
	 public User get(Integer id) throws UserNotFoundException {
		Optional<User> result = repo.findById(id);
		if (result.isPresent())
			return result.get();
		
		throw new UserNotFoundException("Could Not Find Any Users with Id");
	}
	 
	 public void delete(Integer id) throws UserNotFoundException
	 {
		 Long count = repo.countById(id);
		 if(count == null || count == 0) {
			 throw new UserNotFoundException("Could Not Find Any Users with Id");
		 }
			 repo.deleteById(id);
	 }
	 
}
