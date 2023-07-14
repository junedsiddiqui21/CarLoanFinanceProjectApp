package com.bitlogicsystem.carloanfinance.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.bitlogicsystem.carloanfinance.app.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	User findByUsernameAndPassword(String username, String password);

}
