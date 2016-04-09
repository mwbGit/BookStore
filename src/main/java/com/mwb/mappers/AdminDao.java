package com.mwb.mappers;

import com.mwb.entity.Admin;

import java.util.List;
import java.util.Map;

public interface AdminDao {

	public Admin login(Admin admin);
	public void add(Admin admin);
	public Admin find(int id);
	//验证用户名
	public Admin findNameExist(Map<String,Object> map);
	public void delete(int id);
	public void edit(Admin admin);
	public List<Admin> findAll();
}
