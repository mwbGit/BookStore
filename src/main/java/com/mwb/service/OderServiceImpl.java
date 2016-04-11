package com.mwb.service;

import com.mwb.entity.Oder;
import com.mwb.entity.OderDetails;
import com.mwb.entity.User;
import com.mwb.mappers.OderDao;
import com.mwb.mappers.OderDetailsDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/7 0007.
 */
@Service("oderService")
public class OderServiceImpl implements OderService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

    @Autowired
    private OderDao oderDao;
    @Autowired
    private OderDetailsDao oderDetailsDao;
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
        LOGGER.info("updateSend  ");
        Oder oder=oderDao.findById(id);
        if (oder==null)
            return;
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("id",oder.getId());
        map.put("status",1);
        oderDao.send(map);
        List<OderDetails> list=oderDetailsDao.find(oder.getId());
        for (OderDetails oderDetails:list){
            LOGGER.info("updateSend oderDetails ");
            oderDetailsDao.send(map);
        }
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

    @Override
    public void clearOder(User user) {
        oderDao.clearOder(user);
    }
}
