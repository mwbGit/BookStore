package com.mwb.controller;

import com.mwb.entity.*;
import com.mwb.mappers.BookTypeDao;

import com.mwb.service.BookTypeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.Map;

/**
 * 书籍类别控制
 */
@Controller
@RequestMapping("/static/manager")
public class BookTypeController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookTypeController.class);

    @Autowired
    private BookTypeService bookTypeService;

    //ajax 请求
    @RequestMapping("/getBookType")
    @ResponseBody
    public List<BookType> getBookType() {
        System.out.println(bookTypeService.findAll());
        return bookTypeService.findAll();
    }

    //菜单请求
    @RequestMapping("/getBookTypes")
    public String getBookTypes(Map<String, Object> map) {
        LOGGER.info("getBookTypes into ");
        map.put("bookTypes", bookTypeService.findAll());
        return "manager/booktypeshow";
    }
    //删除图书分类
    @RequestMapping("/deleteBookType")
    public String deleteBookType(@RequestParam("id")int id) {
        LOGGER.info("deleteBookType into ");
        bookTypeService.delete(id);
        return "redirect:/static/manager/getBookTypes";
    }
    //添加图书分类
    @RequestMapping("/bookTypeAdd")
    public String bookTypeAdd(BookType bookType) {
        LOGGER.info("bookTypeAdd into ");
        bookType.setName(bookType.getName().trim());
        bookTypeService.add(bookType);
        return "redirect:/static/manager/getBookTypes";
    }

}
