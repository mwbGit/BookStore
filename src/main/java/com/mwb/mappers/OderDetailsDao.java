package com.mwb.mappers;

import com.mwb.entity.Oder;
import com.mwb.entity.OderDetails;

import java.util.List;
import java.util.Map;

public interface OderDetailsDao {

	public void add(OderDetails oderDetails);
	public  List<OderDetails> find(int oderid);
	public void delete(int oderid);
	public void deleteById(int id);
	public void send(Map<String,Object>map);
	public List<OderDetails> findAll();
}
