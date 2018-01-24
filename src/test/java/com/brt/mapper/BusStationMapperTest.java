package com.brt.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.brt.entity.BusStation;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusStationMapperTest {

	@Autowired
	private BusStationMapper busStationMapper;
	
	@Test
	public void testPage() throws Exception {
		//添加分页查询
		PageHelper.startPage(1, 10);//1：代表第一页、10：代表一页10条数据
		List<BusStation> bsList = busStationMapper.query();
		for (int i = 0; i < bsList.size(); i++) {
			System.out.println(bsList.get(i).getStopname());
		}
		
		 // 取分页信息
        PageInfo<BusStation> pageInfo = new PageInfo<BusStation>(bsList);
        long total = pageInfo.getTotal(); //获取总记录数
        System.out.println("---" + total);
		
	}
	
	
	/*
	@Test
	public void testQuery() throws Exception {
		List<BusStation> bsList = busStationMapper.query();
		System.out.println(bsList.toString());
	}
	
	@Test
	public void testGetById() throws Exception {
		BusStation bs = busStationMapper.getById(391081);
		System.out.println(bs.getStopname());
	}
	
	@Test
	public void testInsert() throws Exception {
		BusStation bs = new BusStation();
		bs.setId(1);
		bs.setStopcode("123456");
		bs.setOrdernumber("12");
		bs.setStopname("测试123456");
		bs.setNameforshort("测试123");
		bs.setStoptype("1");
		bs.setLongitude("114.3262220");
		bs.setLatitude("30.5821380");
		busStationMapper.insert(bs);
		
		BusStation gs = busStationMapper.getById(1);
		System.out.println(gs.getStopname());
	}
	
	@Test
	public void testUpdate() throws Exception {
		BusStation bs = new BusStation();
		bs.setId(1);
		bs.setStopcode("123456");
		bs.setOrdernumber("12");
		bs.setStopname("测试789123");
		bs.setNameforshort("测试123");
		bs.setStoptype("1");
		bs.setLongitude("114.3262220");
		bs.setLatitude("30.5821380");
		busStationMapper.update(bs);
		
		BusStation gs = busStationMapper.getById(1);
		System.out.println(gs.getStopname());
	}
	
	@Test
	public void testDelete() throws Exception {
		busStationMapper.delete(1);
	}
	*/
}