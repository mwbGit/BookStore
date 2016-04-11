package com.mwb.mappers;

import com.mwb.entity.Oder;
import com.mwb.entity.User;

import java.util.List;
import java.util.Map;

public interface OderDao {
	public void add(Oder oder);
	public void delete(int id);
	public void send(Map<String, Object> map);
	public Oder findById(int id);
	public List<Oder> find(User user);
	public List<Oder> findOk();
	public List<Oder> findNo();
	//清空未发货订单
	public void clearOder(User user);
}