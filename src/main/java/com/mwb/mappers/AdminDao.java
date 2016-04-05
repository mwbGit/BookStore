package com.mwb.mappers;

import com.mwb.util.Admin;

import java.util.List;

public interface AdminDao {

	public Admin login(Admin Admin);
	public void add(Admin Admin);
	public Admin find(int id);
	public void delete(int id);
	public void edit(Admin Admin);
	public List<Admin> findAll();
}
