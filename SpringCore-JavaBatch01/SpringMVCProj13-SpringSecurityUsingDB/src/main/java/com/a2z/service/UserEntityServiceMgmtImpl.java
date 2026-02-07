package com.a2z.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.a2z.entity.UserEntity;
import com.a2z.repository.UserEntityRepository;

@Service
public class UserEntityServiceMgmtImpl implements IUserServiceMgmt {
	@Autowired
	private UserEntityRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String name)throws UsernameNotFoundException {
		UserEntity user = 
				userRepo.findByUsername(name).orElseThrow(()-> new UsernameNotFoundException("User not found"));
		
		return User.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole())//Admin, user
				.build();
		
	}

	@Override
	public UserEntity findUserById(int id) {
		
		return userRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("user not found with id::"+id));
	}

	@Override
	public String registerUser(UserEntity user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		return "User register sucessfully";
	}
}
