package com.CoderHack.CoderHack.ServiceImpl;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.CoderHack.CoderHack.Exception.CustomException;
import com.CoderHack.CoderHack.Repository.UserRepository;
import com.CoderHack.CoderHack.Service.UserService;
import com.CoderHack.CoderHack.model.RegisterUser;
import com.CoderHack.CoderHack.model.User;
import com.CoderHack.CoderHack.model.UserUpdate;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public List<User> getAllUsers() {
		List<User> users=userRepo.findAll(Sort.by(Sort.Direction.ASC, "score"));
		return users;
	}


	@Override
	public User addUser(RegisterUser registerUser) throws Exception {
		User user=new User();
		user.setUserId(registerUser.getUserId());
		user.setUserName(registerUser.getUserName());
		User getUser=userRepo.save(user);
		return getUser;
	}


	@Override
	public User updateScore(UserUpdate user) throws Exception {
		if(!(user.getScore()>=1 && user.getScore()<=100))
		{
			throw new CustomException("Please enter valid Score");
		}
		String badge="";
		List<String> badges=null;
		if(user.getScore()>=1 && user.getScore()<30)
		{
			badge="Code Ninja";
		} 
		else if(user.getScore()>=30 && user.getScore()<60)
		{
			badge="Code Champ";
		}else if(user.getScore()>=60 && user.getScore()<100)
		{
			badge="Code Master";
		}
		
		Optional<User> userDetails=userRepo.findById(user.getUserId());
		if(userDetails.isEmpty())
		{
			throw new CustomException("please enter valid userId");
		}
		if(userDetails.get().getBadges()!=null && userDetails.get().getBadges().size()>2)
		{
			throw new CustomException("Badges limit is 3");
		}
		if(userDetails.get().getBadges()==null)
		{
			badges=new ArrayList<>();
			badges.add(badge);
			userDetails.get().setBadges(badges);
		}else {
			userDetails.get().getBadges().add(badge);
		}
		
		userDetails.get().setScore(user.getScore());
		User getUser=userRepo.save(userDetails.get());
		return getUser;
	}


	@Override
	public User getUserByUserId(String userId) {
		Optional<User> userDetails=userRepo.findById(userId);
		if(userDetails.isEmpty())
		{
			throw new CustomException("please enter valid userId");
		}
		return userDetails.get();
	}


	@Override
	public void removeUser(String userId) {
		userRepo.deleteById(userId);
	}

}
