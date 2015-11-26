package com.mario.demo.controller;

import java.util.List;

import com.junicorn.mario.db.MarioDb;
import com.junicorn.mario.servlet.wrapper.Request;
import com.junicorn.mario.servlet.wrapper.Response;
import com.mario.demo.model.User;

public class UserController {
	
	public void users(Request request, Response response){
		List<User> users = MarioDb.getList("select * from t_user", User.class);
		if(null != users && users.size() > 0){
			for(User user : users){
				System.out.println(user);
			}
		}
	}
	
}
