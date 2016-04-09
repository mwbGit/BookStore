package com.mwb.mappers;

import java.util.List;
import java.util.Map;

import com.mwb.entity.User;

public interface UserDao {

	public User login(User user);
	public void add(User user);
	public User find(int id);
	//验证用户名
	public User findNameExist(Map<String,Object> map);
	public void delete(int id);
	public void edit(User user);
	public List<User> findAll();
}
