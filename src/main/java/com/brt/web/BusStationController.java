package com.brt.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brt.entity.BusStation;
import com.brt.mapper.BusStationMapper;
import com.brt.util.HTTPRequestUtil;
import com.brt.util.JsonUtil;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping(value="/bs")
public class BusStationController {
	
	@Autowired
	private BusStationMapper busStationMapper;
	
	private JsonUtil jsonutil = new JsonUtil();
	private HTTPRequestUtil requestutil = new HTTPRequestUtil();
	
	@RequestMapping(value="/list", method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String findQuery(HttpServletRequest request) throws IOException{
		String paramstr = requestutil.charReader(request);
		Map<String, Object> map = jsonutil.json2map(paramstr);
		int pageNum = Integer.parseInt((String)map.get("pageNum")) ;	
		int pageSize = Integer.parseInt((String) map.get("pageSize"));	
		PageHelper.startPage(pageNum, pageSize);//pageNum：代表第几页、pageSize：代表一页多少条数据
		List<BusStation> bsList = this.busStationMapper.query();
        
		PageInfo<BusStation> pageInfo = new PageInfo<BusStation>(bsList);
		
		/*PageBean<BusStation> pageInfo = new PageBean<BusStation>(bsList);
		System.out.println(jsonutil.toJson(pageInfo));
		JSONPObject jp = new JSONPObject("callback", jsonutil.toJson(pageInfo));*/
		
		//System.out.println(jsonutil.toJson(bsList));
		return jsonutil.toJson(pageInfo);
	}
	
	@RequestMapping("/add")
	public JSONPObject insert(BusStation bs){
		String result = "";
		try {
			this.busStationMapper.insert(bs);
			result = "success";
		}catch (Exception e) {
			result = "failure";
			e.printStackTrace();
		}
		return new JSONPObject("callback", result);
	}
	
	@RequestMapping("/update")
	public JSONPObject update(BusStation bs){
		String result = "";
		try {
			this.busStationMapper.update(bs);
			result = "success";
		}catch (Exception e) {
			result = "failure";
			e.printStackTrace();
		}
		return new JSONPObject("callback", result);
	}
	
	@RequestMapping("/delete")
	public JSONPObject delete(String id){
		String result = "";
		try {
			this.busStationMapper.delete(Integer.parseInt(id));
			result = "success";
		}catch (Exception e) {
			result = "failure";
			e.printStackTrace();
		}
		return new JSONPObject("callback", result);
	}
	
	
	@RequestMapping(value="/test", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public String test(HttpServletRequest request) throws IOException{
		
		return "weed";
	}
	
}