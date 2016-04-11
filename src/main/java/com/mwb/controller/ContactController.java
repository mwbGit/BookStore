package com.mwb.controller;

import com.mwb.entity.Contact;
import com.mwb.service.ContactService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/9 0009.
 * 留言控制器
 */
@Controller
@RequestMapping("/static")
public class ContactController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;
    @RequestMapping("/sendMessage")
    public String sendMessage(Contact contact) {
        LOGGER.info("sendMessage ");
        if (contact.getMessage()!=null){
            LOGGER.info(" save Message ");
            contact.setDate(new Date());
            contactService.add(contact);
        }
        return "redirect:/static/index.jsp";
    }
    @RequestMapping("manager/deleteMessage")
    public String deleteMessage(@RequestParam("id") int id) {
        LOGGER.info("deleteMessage ");
        contactService.delete(id);
        return "redirect:/static/manager/getMessage";
    }
    @RequestMapping("manager/getMessage")
    public String getMessage(Map<String,Object> map) {
        LOGGER.info("getMessage ");
        map.put("contacts",contactService.findAll());
        return "manager/contact";
    }
}
