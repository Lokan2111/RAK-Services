package org.rak.portal.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.rak.portal.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Integer>{

	User save(User user);
	
	Optional<User> findById(Integer userId);
	
	@Query("FROM User WHERE phoneNumber = ?1")
	Optional<User> findByMobileNumber(BigInteger mobileNumber);
	
	List<User> findAll();
}
