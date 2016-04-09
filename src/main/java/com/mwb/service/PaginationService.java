package com.mwb.service;

import com.mwb.entity.Book;
import com.mwb.entity.Pagination;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/9 0009.
 * 分页操作
 */
public class PaginationService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PaginationService.class);
    //默认大小及起始 热销排行展示数量
    private static final int INDEX=0;
    private static final int SIZE=12;
    private static final int COUNT=20;
    //按类别分页
    public static Map<String,Object> Paging(int tyepeid,Pagination page,BookService bookService,BookTypeService bookTypeService){
        //map 查询参数  books结果list
        Map<String,Object> map=new HashMap<String, Object>();
        Map<String,Object> result=new HashMap<String, Object>();
        List<Book> list;

        if (page.getSize()==null){
            LOGGER.info("into  page index=1");
            //默认第一页开始
            page.setIndex(INDEX);
            page.setSize(SIZE);
        }
        //limit index page.getIndex()=起始页
        int index=0;
        if (page.getIndex()!=0){
            index = (page.getIndex() - 1) * page.getSize();
        }

        //总条数
        if (tyepeid==0){
            //热销
            LOGGER.info("into  count hot");
            page.setCount(COUNT);
        }else {
            LOGGER.info("into  count type");
            page.setCount(bookService.findTypeCount(tyepeid));
        }
        //总页数
        if (page.getCount() % page.getSize() == 0) {
            page.setPages( (page.getCount() / page.getSize()));
        } else {
            page.setPages( (page.getCount() / page.getSize())+1);
        }


        //执行查询
        LOGGER.info("into  page findTypeLimit");
        map.put("booktype",tyepeid);
        map.put("index",index);
        map.put("size",page.getSize());
        
        
        if (tyepeid==0){
            //0代表热销
             list=bookService.findHotLimit(map);
            LOGGER.info("into  list hot");
        }else {
            //类别
             list=bookService.findTypeLimit(map);
            LOGGER.info("into  list type");
        }
        //返回分页信息
        LOGGER.info("into  page return");
        result.put("TypeBooks",list);
        result.put("page",page);
        return result;
    }
}
