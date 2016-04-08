package com.mwb.service;

import com.mwb.entity.Oder;
import com.mwb.entity.User;

import java.util.List;

public interface OderService {
	public void add(Oder oder);
	public void delete(int id);
	public void updateSend(int id);
	public List<Oder> find(User user);
	public List<Oder> findOK();
	public List<Oder> findNo();
}
