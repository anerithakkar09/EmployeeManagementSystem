package com.example.ems.repository;

import com.example.ems.model.User;

public interface UserRepositoryCustom 
{
	User findByUsername(String username);
}
