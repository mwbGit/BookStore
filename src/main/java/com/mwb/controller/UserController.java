package com.mwb.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mwb.entity.*;
import com.mwb.mappers.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mwb.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/static")
public class UserController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //用户登录
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {

        User resultUser = userService.login(user);
        if (resultUser == null) {
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", "�û������������");
            return "redirect:/static/login.jsp";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("User", resultUser);
            return "redirect:/static/index.jsp";
            //return "redirect:/success.jsp";
        }
    }

    //展示所有用户
    @RequestMapping("/manager/getUsers")
    public String getUsers(Map<String, Object> map) {
        LOGGER.info("getUsers into ");
        map.put("users", userService.findAll());
        return "manager/usermanager";
    }

    //升级用户为会员
    @RequestMapping("/manager/UserUpgrade")
    public String UserUpgrade(@RequestParam("id") int id, @RequestParam("members") int members) {
        LOGGER.info("UserUpgrade into ");
        if (members == 0) {
            User user = userService.find(id);
            //1代表会员
            user.setMembers(1);
            userService.edit(user);
        }
        return "redirect:/static/manager/getUsers";
    }

    //升级用户为会员
    @RequestMapping("/manager/UserDelete")
    public String UserDelete(@RequestParam("id") int id) {
        LOGGER.info("UserDelete into ");
        userService.delete(id);
        LOGGER.info("UserDelete ok ");

        return "redirect:/static/manager/getUsers";
    }
}
