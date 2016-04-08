package com.mwb.mappers;

import com.mwb.entity.Oder;
import com.mwb.entity.User;

import java.util.List;

public interface OderDao {
	public void add(Oder oder);
	public void delete(int id);
	public void send(int id);
	public Oder findById(int id);
	public List<Oder> find(User user);
	public List<Oder> findOk();
	public List<Oder> findNo();}
