package com.bitlogicsystem.carloanfinance.app.service;

import com.bitlogicsystem.carloanfinance.app.model.User;

public interface UserService {

	User saveUserData(User a);

	User getUserData(String username, String password);

}
