package com.mwb.service;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mwb.mappers.UserDao;
import com.mwb.entity.User;
@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userDao.add(user);
	}

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		return userDao.find(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	@Override
	public void edit(User user) {
		// TODO Auto-generated method stub
		userDao.edit(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

}
