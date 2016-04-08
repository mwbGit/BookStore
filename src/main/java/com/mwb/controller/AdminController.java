package com.mwb.controller;

import com.mwb.entity.Admin;

import com.mwb.service.AdminService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/static")
public class AdminController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;


    //管理员登录
    @RequestMapping("/manager/LoginAdmin")
    public String Login(Admin admin,HttpServletRequest request) {
        LOGGER.info("Login into ");
        Admin manager = adminService.login(admin);
        if (manager == null) {
            return "redirect:/static/manager/login.jsp";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("admin", manager);
            return "redirect:/static/manager/index.jsp";
        }
    }
    //展示所有管理员
    @RequestMapping("/manager/getAdmins")
    public String getAdmins(Map<String, Object> map) {
        LOGGER.info("getAdmins into ");
        map.put("admins", adminService.findAll());
        return "manager/adminmanager";
    }

    //升级管理员
    @RequestMapping("/manager/AdminUpgrade")
    public String AdminUpgrade(@RequestParam("id") int id, @RequestParam("grade") int grade) {
        LOGGER.info("UserUpgrade into ");
        if (grade == 1) {
            Admin admin = adminService.find(id);
            //2代表高级管理员
            admin.setGrade(2);
            adminService.edit(admin);
            LOGGER.info("UserUpgrade ok ");
        }
        return "redirect:/static/manager/getAdmins";
    }

    //删除
    @RequestMapping("/manager/AdminDelete")
    public String AdminDelete(@RequestParam("id") int id, @RequestParam("grade") int grade) {
        LOGGER.info("AdminDelete into ");
        if (grade != 9) {
            adminService.delete(id);
            LOGGER.info("AdminDelete ok ");
        }
        return "redirect:/static/manager/getAdmins";
    }
    //添加
    @RequestMapping("/manager/Addadmin")
    public String Addadmin(Admin admin) {
        LOGGER.info("Addadmin into ");
        if (admin != null) {
            adminService.add(admin);
            LOGGER.info("Addadmin ok ");
        }
        return "redirect:/static/manager/getAdmins";
    }
    //展示页面
    @RequestMapping("/manager/addAdmin")
    public String addAdmin() {
        LOGGER.info("addAdmin into ");
        return "manager/adminadd";
    }

}