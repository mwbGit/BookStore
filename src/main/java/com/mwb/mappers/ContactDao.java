package com.mwb.mappers;

import com.mwb.entity.Contact;
import com.mwb.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/4/9 0009.
 */
public interface   ContactDao {
    public void add(Contact contact);
    public void delete(int id);
    public Contact find(int id);
    public List<Contact> findAll();
}
