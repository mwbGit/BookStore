package com.mwb.service;

import com.mwb.entity.OderDetails;
import com.mwb.mappers.OderDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/4/7 0007.
 */
@Service("OderDetailsService")
public class OderDetailsServiceImpl implements OderDetailsService{

    @Autowired
    private OderDetailsDao oderDetailsDao;
    @Override
    public void add(OderDetails oderDetails) {
        oderDetailsDao.add(oderDetails);
    }

    @Override
    public List<OderDetails> find(int oderid) {
        return oderDetailsDao.find(oderid);
    }

    @Override
    public void delete(int oderid) {
        oderDetailsDao.delete(oderid);
    }

    @Override
    public List<OderDetails> findAll() {
        return oderDetailsDao.findAll();
    }
}
