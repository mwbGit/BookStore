package com.mwb.util;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2016/4/11 0011.
 * Double 2位
 */
public class FormatDouble {
    public static Double getToDoble(double db){
        DecimalFormat df=new DecimalFormat("0.00");
      return Double.parseDouble(df.format(db));
    }

    public static void main(String[] args) {
        String s="/123411";
        System.out.println(s.substring(1,s.length()));

    }
}
