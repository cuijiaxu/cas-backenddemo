package com.brt.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brt.entity.Route;
import com.brt.mapper.RouteMapper;
import com.brt.util.HTTPRequestUtil;
import com.brt.util.JsonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping(value="/rt")
public class RouteController {
	
	@Autowired
	private RouteMapper routeMapper;
	
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
		
		List<Route> list = this.routeMapper.query();
		PageInfo<Route> pageInfo = new PageInfo<Route>(list);
		
		return jsonutil.toJson(pageInfo);
	}
	
	@RequestMapping("/add")
	public String insert(HttpServletRequest request){
		String result = "";
		try {
			String jsonString = requestutil.charReader(request);
			Route add = jsonutil.fromJson(jsonString, Route.class);
			this.routeMapper.insert(add);
			result = "success";
		}catch (Exception e) {
			result = "failure";
			e.printStackTrace();
		}
		return jsonutil.toJson(result);
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request){
		String result = "";
		try {
			String jsonString = requestutil.charReader(request);
			Route upd = jsonutil.fromJson(jsonString, Route.class);
			this.routeMapper.update(upd);
			result = "success";
		}catch (Exception e) {
			result = "failure";
			e.printStackTrace();
		}
		return jsonutil.toJson(result);
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request){
		String result = "";
		try {
			String jsonString = requestutil.charReader(request);
			Map<String, Object> map = jsonutil.json2map(jsonString);
			int id = Integer.parseInt((String)map.get("id")) ;	
			this.routeMapper.delete(id);
			result = "success";
		}catch (Exception e) {
			result = "failure";
			e.printStackTrace();
		}
		return jsonutil.toJson(result);
	}
	
}