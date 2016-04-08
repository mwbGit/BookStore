package com.mwb.mappers;

import com.mwb.entity.Oder;
import com.mwb.entity.OderDetails;

import java.util.List;

public interface OderDetailsDao {

	public void add(OderDetails oderDetails);
	public  List<OderDetails> find(int oderid);
	public void delete(int oderid);
	public List<OderDetails> findAll();
}
