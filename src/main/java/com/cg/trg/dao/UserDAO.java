package com.cg.trg.dao;



import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.trg.entity.User;

/**
 * 
 * @author NIKHIL
 *
 */

@Repository
public interface UserDAO extends JpaRepository <User, Integer>{
	@Query("select cm from User cm where cm.userEmail=?1")
	Optional<User> findByEmailId(String email);
	
	@Query("select c from User c where c.userName=?1")
	Optional<User> findByUserName(String username);

//	@Query("select c from User c where c.userPassword=?1")
//	Optional<User> findByPassword(String password);
//	

}
