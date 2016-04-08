package com.mwb.service;

import com.mwb.entity.OderDetails;

import java.util.List;

public interface OderDetailsService {

	public void add(OderDetails oderDetails);
	public  List<OderDetails> find(int oderid);
	public void delete(int oderid);
	public List<OderDetails> findAll();
}
