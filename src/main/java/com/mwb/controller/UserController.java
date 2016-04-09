package com.mwb.controller;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mwb.entity.*;
import com.mwb.util.MD5;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mwb.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 后台 删除 展示 升级会员
 * 前台 用户登录 退出 修改
 */
@Controller
@RequestMapping("/static")
public class UserController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    //用户登录
    @RequestMapping("/Login")
    public String login(User user ,HttpServletRequest request) {
        user.setPassword(MD5.GetMD5Code(user.getPassword()));
        User user1 = userService.login(user);
        if (user1 == null) {
            LOGGER.info("user1 =null ");
            return "login";
        } else {
            LOGGER.info("user1 =ok ");
            //存储最后登录时间
            user1.setLastdate(new Date());
            userService.edit(user1);
            HttpSession session = request.getSession();
            session.setAttribute("user", user1);
            return "redirect:/static/index.jsp";
        }

    }
    //退出
    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request) {
        LOGGER.info("logOut into ");
        request.getSession().removeAttribute("user");
        return "redirect:/static/index.jsp";
    }

    //获取修改页面
    @RequestMapping("/userEdit")
    public String userEdit(HttpServletRequest request) {
        LOGGER.info("userEdit into ");
        User user=(User)request.getSession().getAttribute("user");
        request.setAttribute("UserShow",user);
        return "useredit";
    }
    //修改
    @RequestMapping("/getEdit")
    public String getEdit(User user,HttpServletRequest request) {
        LOGGER.info("getEdit into ");
        //防止修改其他用户
       User u= (User)request.getSession().getAttribute("user");
        if (u.getId()!=user.getId()){
            LOGGER.info("no user id ");
            request.setAttribute("UserShow","u");
            return "useredit";
        }
        //验证用户名是否重复
        if(userService.findNameExist(user)!=null){
            LOGGER.info("getEdit name Exist ");
            request.setAttribute("err", "用户名重复");
            request.setAttribute("UserShow",u);
            return "useredit";
        }
        //修改
        user.setPassword(MD5.GetMD5Code(user.getPassword()));
        userService.edit(user);
        LOGGER.info("getEdit edit ok ");
        request.getSession().removeAttribute("user");
        return "redirect:/static/login.jsp";
    }
    //注册
    @RequestMapping("/getRegister")
    public String getRegister(User user,HttpServletRequest request) {
        LOGGER.info("getRegister into ");
        if(userService.findNameExist(user)!=null){
            LOGGER.info("getEdit name Exist ");
            request.setAttribute("err","用户名重复");
            request.setAttribute("userAdd",user);
            return "register";
        }
        //加密 注册时间
        user.setPassword(MD5.GetMD5Code(user.getPassword()));
        user.setJoindate(new Date());
        userService.add(user);
        return "redirect:/static/login.jsp";
    }
//后台----------------
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

    //删除
    @RequestMapping("/manager/UserDelete")
    public String UserDelete(@RequestParam("id") int id) {
        LOGGER.info("UserDelete into ");
        userService.delete(id);
        LOGGER.info("UserDelete ok ");

        return "redirect:/static/manager/getUsers";
    }
}
