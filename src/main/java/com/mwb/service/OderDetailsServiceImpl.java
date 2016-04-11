package com.mwb.service;

import com.mwb.entity.Oder;
import com.mwb.entity.OderDetails;
import com.mwb.entity.User;
import com.mwb.mappers.OderDao;
import com.mwb.mappers.OderDetailsDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/7 0007.
 */
@Service("OderDetailsService")
public class OderDetailsServiceImpl implements OderDetailsService{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OderDetailsServiceImpl.class);

    @Autowired
    private OderDetailsDao oderDetailsDao;
    @Autowired
    private OderDao oderDao;
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
    public void deleteById(int id) {
        oderDetailsDao.deleteById(id);
    }

    @Override
    public List<OderDetails> findAll() {
        return oderDetailsDao.findAll();
    }
    @Override
    public List<OderDetails> getOder(User user) {
        LOGGER.info("user getOder into ");
        List<Oder> list=oderDao.find(user);
        List<OderDetails> result=new ArrayList<OderDetails>();
        for (Oder oder:list){
            List<OderDetails> list2=oderDetailsDao.find(oder.getId());
            for (OderDetails oderDetails:list2){
                result.add(oderDetails);
            }
        }
        return result;
    }
}
