package com.mwb.service;

import com.mwb.entity.Admin;
import com.mwb.mappers.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/7 0007.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }

    @Override
    public void add(Admin admin) {
        adminDao.add(admin);
    }

    @Override
    public Admin find(int id) {
        return  adminDao.find(id);
    }

    @Override
    public Admin findNameExist(Admin admin) {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("name",admin.getName());
        if (admin.getId()!=null){
            map.put("id",admin.getId());
        }
        return adminDao.findNameExist(map);
    }

    @Override
    public void delete(int id) {
        adminDao.delete(id);
    }

    @Override
    public void edit(Admin admin) {
        adminDao.edit(admin);
    }

    @Override
    public List<Admin> findAll() {
        return  adminDao.findAll();
    }
}
