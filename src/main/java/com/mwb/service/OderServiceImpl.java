package com.mwb.service;

import com.mwb.entity.Oder;
import com.mwb.entity.User;
import com.mwb.mappers.OderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/4/7 0007.
 */
@Service("oderService")
public class OderServiceImpl implements OderService {
    @Autowired
    private OderDao oderDao;
    @Override
    public void add(Oder oder) {
        oderDao.add(oder);
    }

    @Override
    public void delete(int id) {
        oderDao.delete(id);
    }

    @Override
    public void updateSend(int id) {
        oderDao.send(id);
    }

    @Override
    public List<Oder> find(User user) {
        return oderDao.find(user);
    }

    @Override
    public List<Oder> findOK() {
        return oderDao.findOk();
    }

    @Override
    public List<Oder> findNo() {
        return oderDao.findNo();
    }
}
