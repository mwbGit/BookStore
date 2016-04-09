package com.mwb.service;

import com.mwb.entity.Contact;

import java.util.List;

/**
 * Created by Administrator on 2016/4/9 0009.
 *
 */

public interface ContactService {
    public void add(Contact contact);
    public void delete(int id);
    public Contact find(int id);
    public List<Contact> findAll();
}
