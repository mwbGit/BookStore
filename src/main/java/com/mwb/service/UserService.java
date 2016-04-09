package com.mwb.service;

import java.util.List;

import com.mwb.entity.User;

public interface UserService {

	public User login(User user);
	public void add(User user);
	public User find(int id);
	//验证用户名
	public User findNameExist(User user);
	public void delete(int id);
	public void edit(User user);
	public List<User> findAll();
}
