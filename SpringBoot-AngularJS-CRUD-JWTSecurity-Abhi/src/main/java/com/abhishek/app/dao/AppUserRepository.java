package com.abhishek.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.app.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findOneByUsername(String username);
}