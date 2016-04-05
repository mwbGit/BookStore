package com.mwb.mappers;

import com.mwb.entity.Oder;
import com.mwb.entity.User;

import java.util.List;

public interface OderDao {
	public void add(Oder oder);
	public void delete(int id);
	public List<Oder> find(User user);
	public List<Oder> findAll();
}
