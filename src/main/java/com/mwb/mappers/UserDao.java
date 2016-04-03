package com.mwb.mappers;

import java.util.List;

import com.mwb.entity.User;

public interface UserDao {

	public User login(User user);
	public void add(User user);
	public User find(int id);
	public void delete(int id);
	public void edit(User user);
	public List<User> findAll();
}
