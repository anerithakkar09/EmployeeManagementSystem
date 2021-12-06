package com.example.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ems.model.User;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom
{
}
