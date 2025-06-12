package com.stumic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stumic.model.Users;
import com.stumic.repository.UserRepository;

@Service
public class UserService {
       
	
	@Autowired
	private UserRepository userrepository;
	
	public List<Users> getAll() {
		return userrepository.findAll();
	}
	
	
    public Users create(Users u) {
    	return userrepository.save(u);
    }
    

	public Users getUserId( Long id) {
    	return userrepository.findById(id).orElse(null);
    }
    
	public Users updateUser (Long id, Users updateduser) {
		return userrepository.findById(id).map(exixtinguser->{
			exixtinguser.setName(updateduser.getName());
			exixtinguser.setEmail(updateduser.getEmail());
			
			return userrepository.save(exixtinguser);
				
		}).orElse(null);
	}
	
	
	
	public Users deleteById( Long id) {
		Users deleteuser=userrepository.findById(id).orElse(null);
		return deleteuser;
	}

	public void deleteAll() {
		   userrepository.deleteAll();
		}

}

