package com.mwb.mappers;

import com.mwb.entity.Cart;
import com.mwb.entity.User;

import java.util.List;

public interface CartDao {


	public void add(Cart cart);
	public void delete(int id);
	public void clear(User user);
	public void edit(Cart cart);
	public List<Cart> find(User user);
}
