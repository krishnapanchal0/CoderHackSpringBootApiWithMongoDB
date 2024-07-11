package com.CoderHack.CoderHack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CoderHack.CoderHack.Service.UserService;
import com.CoderHack.CoderHack.model.RegisterUser;
import com.CoderHack.CoderHack.model.User;
import com.CoderHack.CoderHack.model.UserUpdate;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody RegisterUser user) throws Exception
	{
		User addedUser=userService.addUser(user);
		return ResponseEntity.ok(addedUser);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		List<User> users=userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@PutMapping("/users")
	public ResponseEntity<User> updateScore(@RequestBody UserUpdate userUpdate) throws Exception
	{
		User user=userService.updateScore(userUpdate);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") String userId){
		User user=userService.getUserByUserId(userId);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/user/{userId}")
	public BodyBuilder removeUser(@PathVariable("userId") String userId){
		userService.removeUser(userId);
		return ResponseEntity.ok();
	}
	
}
