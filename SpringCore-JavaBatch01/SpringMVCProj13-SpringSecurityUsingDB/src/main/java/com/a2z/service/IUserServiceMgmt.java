package com.a2z.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.a2z.entity.UserEntity;

public interface IUserServiceMgmt extends UserDetailsService{
	public UserEntity findUserById(int id);
	public String registerUser(UserEntity user);
}
