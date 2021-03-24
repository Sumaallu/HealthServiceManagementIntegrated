package com.cg.trg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.trg.entity.User;




	@Repository
	public interface AuthenticateUserDAO extends JpaRepository<User, Integer> {
		@Query("select cm from User cm where cm.userEmail=?1")
		Optional<User> findByEmailId(String email);
	}

