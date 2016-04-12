package com.mwb.service;

import com.mwb.entity.Book;
import com.mwb.entity.Cart;
import com.mwb.entity.OderDetails;
import com.mwb.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/4/10 0010.
 */
public interface CartService {
    public void add(Cart cart);
    public void delete(int id);
    public void clear(User user);
    public void edit(Cart cart);
    public Cart findById(int id);
    public List<Cart> find(User user);
   public List<Book> checkOut(User user,int[] id);


}
