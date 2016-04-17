package com.mwb.controller;

import com.mwb.entity.Book;
import com.mwb.entity.Cart;
import com.mwb.entity.OderDetails;
import com.mwb.entity.User;
import com.mwb.service.BookService;
import com.mwb.service.CartService;
import com.mwb.service.OderDetailsService;
import com.mwb.service.OderService;
import com.mwb.util.FormatDouble;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/10 0010.
 * 购物车 订单
 */
@Controller
@RequestMapping("/static")
public class CartController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CartController.class);
    @Autowired
    private CartService cartService;
    @Autowired
    private OderDetailsService oderDetailsService;
    @Autowired
    private OderService oderService;
    @Autowired
    private BookService bookService;

    //进入购物车
    @RequestMapping("/getMyCar")
    public String intoCart(HttpServletRequest request, Map<String,Object> map) {
        LOGGER.info("into  intoCart");
        User user =(User)request.getSession().getAttribute("user");
        //用户是否登录
        if (user==null){
            LOGGER.info("user  no login");
            return "login";
        }
        //返回信息
        int sum=0;double price=0;
        List<Cart> list=cartService.find(user);
        for (Cart car : list){
            sum+=car.getNum();
            if(car.getUser().getMembers()==1){
                car.setPrice(car.getBook().getMemberprice()*car.getNum());
                cartService.edit( car);
            }
            price+=car.getPrice();
            if(car.getBook().getInventory()-car.getNum()<0) {
                //库存不足
                car.setFlag(false);
            }else {
                car.setFlag(true);
            }
        }
        if (list.size()==0){
            //购物车空
            map.put("sky","null");
        }else {
            map.put("carts",list);
            map.put("price", FormatDouble.getToDoble(price));
            map.put("sum",sum);
        }
        LOGGER.info("cart map={}",map);
        return "cart";
    }

    //添加书籍到购物车
    @RequestMapping("/addCart")
    @ResponseBody
    public Map<String,Object> addCart(@RequestParam("id") int id, HttpServletRequest request) {
        LOGGER.info("into  getShow");
        User user =(User)request.getSession().getAttribute("user");
        Map<String,Object> map=new HashMap<String, Object>();
        //用户是否登录
        if (user==null){
            LOGGER.info("user  no login");
            map.put("err","no");
            return map;
        }
        Book book=new Book();
        book.setId(id);
        Cart cart=new Cart();
        cart.setUser(user);
        cart.setBook(book);
        cart.setNum(1);
        //添加
        cartService.add(cart);
        //返回信息
        int sum=0;double price=0;
        List<Cart> list=cartService.find(user);
        for (Cart car : list){
            sum+=car.getNum();
            price+=car.getPrice();
        }
        map.put("sum",sum);
        map.put("price", FormatDouble.getToDoble(price));
        map.put("err","yes");
        LOGGER.info("cart map={}",map);
        return map;
    }
    //删除该书籍
    @RequestMapping("/deleteCart")
    public String deleteCart(@RequestParam("id") int id,HttpServletRequest request) {
        LOGGER.info("into  deleteCart");
        User user =(User)request.getSession().getAttribute("user");
        //删除
        List<Cart> list=cartService.find(user);
        for (Cart car : list){
            if (car.getId()==id){
                LOGGER.info("cart delete ");
                cartService.delete(id);
            }
        }
        return "redirect:/static/getMyCar";
    }
    //修改数量
    @RequestMapping("/editCart")
    @ResponseBody
    public Map<String,Object> editCart(@RequestParam("id") int id,@RequestParam(required = false,value = "num") Integer num,
                           @RequestParam("type") String type,  HttpServletRequest request) {
        LOGGER.info("into  editCart");
        User user =(User)request.getSession().getAttribute("user");
        Map<String,Object> map=new HashMap<String, Object>();
        Cart cart=cartService.findById(id);
        //判断是否是当前用户
        if (cart.getUser().getId()!=user.getId()){
            LOGGER.info("no cur user");
            return null;
        }
        if (type.equals("add")) {
            cart.setNum(cart.getNum()+1);
        }else  if (type.equals("min")){
            cart.setNum(cart.getNum()-1);
        }else if (type.equals("put")){
            cart.setNum(num);
        }else {
            return null;
        }
        cartService.edit(cart);
        cart=cartService.findById(id);
        if (cart==null){
            map.put("num",0);
        }else {
            if(cart.getBook().getInventory()-cart.getNum()<0) {
                //库存不足
                cart.setFlag(false);
            }else {
                cart.setFlag(true);
            }
            map.put("num",cart.getNum());
            //返回信息
            map.put("flag",cart.isFlag());
            map.put("price",cart.getPrice());
        }
        return map;
    }
    //清空
    @RequestMapping("/clearCart")
    public String  clearCart(HttpServletRequest request) {
        LOGGER.info("into  clearCart");
        User user =(User)request.getSession().getAttribute("user");
        cartService.clear(user);
        LOGGER.info("cart clear");
        return "redirect:/static/getMyCar";
    }
    //结算
    @RequestMapping("/checkOut")
    public String  checkOut(@RequestParam(required =false,value = "cartid")int[] cartid,HttpServletRequest request) {
        LOGGER.info("into  checkOut");
        if (cartid!=null){
            User user =(User)request.getSession().getAttribute("user");
            cartService.checkOut(user,cartid);
            LOGGER.info("cart clear");
        }
        return "redirect:/static/getMyCar";
    }

    //用户查看订单
    @RequestMapping("/getOder")
    public String  getOder(HttpServletRequest request,Map<String,Object> map) {
        LOGGER.info("into  getOder");
        User user =(User)request.getSession().getAttribute("user");
        //用户是否登录
        if (user==null){
            LOGGER.info("user  no login");
            return "login";
        }
        List<OderDetails> list=oderDetailsService.getOder(user);
        if (list.size()==0){
            //订单为空
            map.put("sky","null");
        }else {
            map.put("oders",list);
        }
        return "oder";
    }
    //用户删除订单
    @RequestMapping("/deleteOder")
    public String  deleteOder(@RequestParam("id")int id) {
        LOGGER.info("into  deleteOder");
        oderDetailsService.deleteById(id);
        return "redirect:/static/getOder";
    }
    //清空已发货订单
    @RequestMapping("/clearOder")
    public String  clearOder(HttpServletRequest request) {
        LOGGER.info("into  clearOder");
        User user=(User) request.getSession().getAttribute("user");
        oderService.clearOder(user);
        return "redirect:/static/getOder";
    }


}
