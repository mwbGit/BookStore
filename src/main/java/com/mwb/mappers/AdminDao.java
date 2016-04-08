package com.mwb.mappers;

import com.mwb.entity.Admin;

import java.util.List;

public interface AdminDao {

	public Admin login(Admin admin);
	public void add(Admin admin);
	public Admin find(int id);
	public void delete(int id);
	public void edit(Admin admin);
	public List<Admin> findAll();
}
