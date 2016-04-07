package com.mwb.controller;


import com.mwb.entity.OderDetails;
import com.mwb.service.OderDetailsService;
import com.mwb.service.OderService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/static/manager")
public class OderController {
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OderController.class);

	@Autowired
	private OderService oderService;
	@Autowired
	private OderDetailsService oderDetailsService;

	//展示订单已发货
	@RequestMapping("/getOderOver")
	public String getOderOver(Map<String,Object> map){
		LOGGER.info("request getOderOver=");
		map.put("oders",oderService.findOK());
		LOGGER.info("getOderOver ok");
		return "manager/oderovershow";
	}
	//删除订单
	@RequestMapping("/deleteOder")
	public String deleteOder(@RequestParam("id") int id){
		LOGGER.info("request deleteOder=");
		oderService.delete(id);
		LOGGER.info("deleteOder ok");
		return "redirect:/static/manager/getOderOver";
	}
	//展示未发货
	@RequestMapping("/getOders")
	public String getOders(Map<String,Object> map){
		LOGGER.info("request getOders=");
		map.put("oders",oderService.findNo());

		LOGGER.info("book add ok");
		return "manager/odershow";
	}
	//发货
	@RequestMapping("/OderSend")
	public String OderSend(@RequestParam("id") int id){
		LOGGER.info("request OderSend=");
		oderService.updateSend(id);
		LOGGER.info("book add ok");
		return "redirect:/static/manager/getOders";
	}
	//发货
	@RequestMapping("/getOderDetails")
	@ResponseBody
	public List<OderDetails> getOderDetails(@RequestParam("oderid") int oderid){
		LOGGER.info("request getOderDetails=");
		List<OderDetails>  list=oderDetailsService.find(oderid);
		return list;
	}
}
