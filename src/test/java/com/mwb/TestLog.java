package com.mwb;

import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/4/13 0013.
 */
public class TestLog {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestLog.class);

    @Test
    public void Show(){
        System.out.println("22");
        LOGGER.info("111");
    }
}
