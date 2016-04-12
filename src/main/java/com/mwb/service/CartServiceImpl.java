package com.mwb.service;

import com.mwb.controller.BookInfoController;
import com.mwb.entity.*;
import com.mwb.mappers.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/4/10 0010.
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

    @Autowired
    private CartDao cartDao;
    @Autowired
    private UserDao userService;
    @Autowired
    private BookDao bookService;
    @Autowired
    private OderDao oderService;
    @Autowired
    private OderDetailsDao oderDetailsService;

    @Override
    public void add(Cart cart) {
        if (cart.getNum()==0||cart.getUser().getId()==null||cart.getBook().getId()==null){
            LOGGER.info("cart add err");
            return;
        }
        User user = userService.find(cart.getUser().getId());
        Book book = bookService.find(cart.getBook().getId());
        if (user != null &&book!= null) {
            List<Cart> list=cartDao.find(user);
            for (Cart c:list){
                //购物车里有这本书
                if (c.getBook().getId()==book.getId()){
                    c.setNum(c.getNum()+1);
                    LOGGER.info("cart have book into edit ");
                    cartDao.edit(c);
                    return;
                }
            }
            LOGGER.info("cart add ");
            cart.setPrice(user.getMembers()==0?cart.getNum()*book.getMarketprice():cart.getNum()*book.getMemberprice());
            cartDao.add(cart);
        }
    }

    @Override
    public void delete(int id) {
        cartDao.delete(id);
    }

    @Override
    public void clear(User user) {
        if (user.getId()!=null)
        cartDao.clear(user);
    }

    @Override
    public void edit(Cart cart) {
        if (cart.getNum()==0){
         delete(cart.getId());
            return;
        }
        User user =cart.getUser();
        if (user==null){
            LOGGER.info("cart user=null ");
            return;
        }

        List<Cart> list=cartDao.find(user);
        for(Cart c:list){
            if (c.getId()==cart.getId()){
                LOGGER.info("cart edit num price ");
                Book book=bookService.find(c.getBook().getId());
                c.setPrice(user.getMembers() == 0 ? cart.getNum() * book.getMarketprice() : cart.getNum() * book.getMemberprice());
                c.setNum(cart.getNum());
                cartDao.edit(c);
            }
        }

    }

    @Override
    public Cart findById(int id) {
        return cartDao.findById(id);
    }

    @Override
    public List<Cart> find(User user) {
        return cartDao.find(user);
    }

    //结账
    @Override
    public List<Book> checkOut(User user, int[] id) {
        LOGGER.info("cart edit num price ");
        List<Book> list=new ArrayList<Book>();
        if (id.length==0){
            return  list;
        }
        Oder oder=new Oder();
        Date date=new  Date();
        //订单编号
        oder.setId((int)(date.getTime()));
        oder.setUser(user);
        oder.setRealname(user.getRealname());
        oder.setAdress(user.getAddress());
        oder.setDate(date);
        oder.setStatus(0);
        oder.setTel(user.getTel());
        for (int i=0;i<id.length;i++){
            Cart cart=cartDao.findById(id[i]);
            if(cart.getBook().getInventory()-cart.getNum()>=0) {
                //订单总价 数量赋值
                oder.setNum(oder.getNum() + cart.getNum());
                oder.setPrice(oder.getPrice()+cart.getPrice());
            }else {
                //库存不足
                list.add(cart.getBook());
            }
        }
        //存储订单
        oderService.add(oder);
        for (int i=0;i<id.length;i++){
            Cart cart=cartDao.findById(id[i]);
            Book book=cart.getBook();
            OderDetails oderDetails=new OderDetails();
            if(book.getInventory()-cart.getNum()>=0) {
                //库存减
                book.setInventory(book.getInventory() - cart.getNum());
                //销量加
                book.setVolume(book.getVolume() + cart.getNum());
                //书籍信息存储
                bookService.edit(book);
                //订单详情
                oderDetails.setOder(oder);
                oderDetails.setNum(cart.getNum());
                oderDetails.setPrice(cart.getPrice());
                oderDetails.setStatus(0);
                oderDetails.setBook(book);
                //存储订单详情
                oderDetailsService.add(oderDetails);
                //购物车移除
                cartDao.delete(id[i]);
                LOGGER.info("cart checkOut ok ");
            }
        }
        return list;
    }


}
