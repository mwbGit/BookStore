package com.mwb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/4/5 0005.
 * 格式化日期
 */
public class FomateDate {
    public static String fomattoString(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str=sdf.format(date);
        return str;
    }


}
