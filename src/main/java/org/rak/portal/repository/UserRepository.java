package org.rak.portal.repository;

import java.util.List;
import java.util.Optional;

import org.rak.portal.domain.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Integer>{

	User save(User user);
	
	Optional<User> findById(Integer userId);
	
	List<User> findAll();
}
