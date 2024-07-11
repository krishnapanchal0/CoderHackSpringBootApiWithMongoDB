package com.CoderHack.CoderHack.Service;

import java.util.List;

import com.CoderHack.CoderHack.model.RegisterUser;
import com.CoderHack.CoderHack.model.User;
import com.CoderHack.CoderHack.model.UserUpdate;

public interface  UserService {

	public List<User> getAllUsers();

	public User addUser(RegisterUser user) throws Exception;

	public User updateScore(UserUpdate userUpdate) throws Exception;

	public User getUserByUserId(String userId);

	public void removeUser(String userId);
}
