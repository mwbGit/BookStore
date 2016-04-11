package com.mwb.service;

import com.mwb.entity.OderDetails;
import com.mwb.entity.User;

import java.util.List;

public interface OderDetailsService {

	public void add(OderDetails oderDetails);
	public  List<OderDetails> find(int oderid);
	public void delete(int oderid);
	public void deleteById(int id);
	public List<OderDetails> findAll();
	//用户查看订单
	public List<OderDetails> getOder(User user);
}
