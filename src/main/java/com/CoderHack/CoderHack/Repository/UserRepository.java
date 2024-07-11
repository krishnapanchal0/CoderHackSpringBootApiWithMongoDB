package com.CoderHack.CoderHack.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.CoderHack.CoderHack.model.User;

public interface UserRepository extends MongoRepository<User,String>{

	@Query("{userId='?0'}")
	User findUserByUserId(String userId);
}
