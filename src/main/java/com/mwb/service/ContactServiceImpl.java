package com.mwb.service;

import com.mwb.entity.Contact;
import com.mwb.mappers.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/4/9 0009.
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDao contactDao;
    @Override
    public void add(Contact contact) {
        contactDao.add(contact);
    }

    @Override
    public void delete(int id) {
        contactDao.delete(id);
    }

    @Override
    public Contact find(int id) {
        return contactDao.find(id);
    }

    @Override
    public List<Contact> findAll() {
        return contactDao.findAll();
    }
}
