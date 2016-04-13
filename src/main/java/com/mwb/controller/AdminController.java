package com.mwb.controller;

import com.mwb.entity.Admin;

import com.mwb.service.AdminService;
import com.mwb.util.MD5;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * 后台
 * 管理员
 */
@Controller
@RequestMapping("/static/manager")
public class AdminController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    //管理员登录
    @RequestMapping("/adminlogin")
    public String adminlogin() {
        return "manager/login";
    }
    @RequestMapping("/index")
    public String index() {
        return "manager/index";
    }
    //管理员登录
    @RequestMapping("/LoginAdmin")
    public String Login(Admin admin,HttpServletRequest request) {
        LOGGER.info("Login into ");
        admin.setPassword(MD5.GetMD5Code(admin.getPassword()));
        Admin manager = adminService.login(admin);
        if (manager == null) {
            LOGGER.info("admin =null ");
            return "redirect:/static/manager/adminlogin";
        } else {
            LOGGER.info("admin =ok ");
            manager.setLastdate(new Date());
            adminService.edit(manager);
            HttpSession session = request.getSession();
            session.setAttribute("admin", manager);
            return "redirect:/static/manager/index";
        }
    }
    //展示所有管理员
    @RequestMapping("/getAdmins")
    public String getAdmins(Map<String, Object> map) {
        LOGGER.info("getAdmins into ");
        map.put("admins", adminService.findAll());
        return "manager/adminedit";
    }

    //升级管理员
    @RequestMapping("/AdminUpgrade")
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
    @RequestMapping("/AdminDelete")
    public String AdminDelete(@RequestParam("id") int id, @RequestParam("grade") int grade) {
        LOGGER.info("AdminDelete into ");
        if (grade != 9) {
            adminService.delete(id);
            LOGGER.info("AdminDelete ok ");
        }
        return "redirect:/static/manager/getAdmins";
    }
    //添加
    @RequestMapping("/Addadmin")
    public String Addadmin(Admin admin,Map<String,Object> map) {
        LOGGER.info("Addadmin into ");
        if(adminService.findNameExist(admin)!=null){
            LOGGER.info("Addadmin name Exist ");
            map.put("err", "用户名重复");
            map.put("adminAdd", admin);
            return "manager/adminadd";
        }
        if (admin != null) {
            admin.setPassword(MD5.GetMD5Code(admin.getPassword()));
            admin.setName(admin.getName().trim());
            admin.setEmail(admin.getEmail().trim());
            adminService.add(admin);
            LOGGER.info("Addadmin ok ");
        }
        return "redirect:/static/manager/getAdmins";
    }
    //展示页面
    @RequestMapping("/addAdmin")
    public String addAdmin() {
        LOGGER.info("addAdmin into ");
        return "manager/adminadd";
    }
    //退出
    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request) {
        LOGGER.info("logOut into ");
        request.getSession().removeAttribute("admin");
        return "redirect:/static/manager/adminlogin";
    }
    //展示页面
    @RequestMapping("/getAdminEdit")
    public String getAdminEdit() {
        LOGGER.info("getAdminEdit into ");
        return "manager/adminedit";
    }
    //修改信息
    @RequestMapping("/EditPassword")
    public String EditPassword(Admin admin,Map<String,Object> map,HttpServletRequest request) {
        LOGGER.info("EditPassword into ");
        //防止修改其他用户
        Admin u= (Admin)request.getSession().getAttribute("admin");
        if (u.getId()!=admin.getId()){
            LOGGER.info("no admin id ");
            return "manager/adminedit";
        }
        if(adminService.findNameExist(admin)!=null){
            LOGGER.info("Addadmin name Exist ");
            map.put("err", "用户名重复");
            return "manager/adminedit";
        }
        admin.setPassword(MD5.GetMD5Code(admin.getPassword()));
        admin.setName(admin.getName().trim());
        admin.setEmail(admin.getEmail().trim());
        adminService.edit(admin);
        request.getSession().removeAttribute("admin");
        return "redirect:/static/manager/adminlogin";
    }

}
