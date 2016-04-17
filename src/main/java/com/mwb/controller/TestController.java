package com.mwb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2016/4/14 0014.
 * 异常测试
 */
@Controller
public class TestController {
    @RequestMapping("/static/getTest")
    public String getTest(@RequestParam("id") int id){
        int i=10/id;
        return "manager/err";
    }

}
