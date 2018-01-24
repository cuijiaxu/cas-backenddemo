package com.brt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.brt.entity.Station;

public interface StationMapper {
	
	@Select("select * from tb_station")
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "code", column = "code"),
		@Result(property = "name", column = "name"),
		@Result(property = "nameforshort", column = "nameforshort"),
		@Result(property = "obuid", column = "obuid"),
		@Result(property = "parkingarea", column = "parkingarea"),
		@Result(property = "ordernum", column = "ordernum"),
		@Result(property = "type", column = "type"),
		@Result(property = "address", column = "address"),
		@Result(property = "regioncode", column = "regioncode"),
		@Result(property = "streetcode", column = "streetcode"),
		@Result(property = "longitude", column = "longitude"),
		@Result(property = "latitude", column = "latitude"),
		@Result(property = "arrivalradius", column = "arrivalradius"),
		@Result(property = "departureradius", column = "departureradius"),
		@Result(property = "arrivalsoundfilename", column = "arrivalsoundfilename"),
		@Result(property = "arrivalvideofilename", column = "arrivalvideofilename"),
		@Result(property = "departuresoundfilename", column = "departuresoundfilename"),
		@Result(property = "departvideofilename", column = "departvideofilename"),
		@Result(property = "instopledcmd", column = "instopledcmd"),
		@Result(property = "outstopledcmd", column = "outstopledcmd"),
		@Result(property = "status", column = "status"),
		@Result(property = "mileage", column = "mileage"),
		@Result(property = "createtime", column = "createtime")
	})
	List<Station> query();
	
	@Select("select * from tb_station where id = #{id}")
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "code", column = "code"),
		@Result(property = "name", column = "name"),
		@Result(property = "nameforshort", column = "nameforshort"),
		@Result(property = "obuid", column = "obuid"),
		@Result(property = "parkingarea", column = "parkingarea"),
		@Result(property = "ordernum", column = "ordernum"),
		@Result(property = "type", column = "type"),
		@Result(property = "address", column = "address"),
		@Result(property = "regioncode", column = "regioncode"),
		@Result(property = "streetcode", column = "streetcode"),
		@Result(property = "longitude", column = "longitude"),
		@Result(property = "latitude", column = "latitude"),
		@Result(property = "arrivalradius", column = "arrivalradius"),
		@Result(property = "departureradius", column = "departureradius"),
		@Result(property = "arrivalsoundfilename", column = "arrivalsoundfilename"),
		@Result(property = "arrivalvideofilename", column = "arrivalvideofilename"),
		@Result(property = "departuresoundfilename", column = "departuresoundfilename"),
		@Result(property = "departvideofilename", column = "departvideofilename"),
		@Result(property = "instopledcmd", column = "instopledcmd"),
		@Result(property = "outstopledcmd", column = "outstopledcmd"),
		@Result(property = "status", column = "status"),
		@Result(property = "mileage", column = "mileage"),
		@Result(property = "createtime", column = "createtime")
	})
	Station getById(int id);

	@Insert("insert into tb_station (id, code, name, nameforshort, obuid, parkingarea, ordernum, type, address, regioncode, streetcode, longitude, latitude, arrivalradius, departureradius, arrivalsoundfilename, arrivalvideofilename, departuresoundfilename, departvideofilename, instopledcmd, outstopledcmd, status, mileage, createtime) "
		   + "values (#{id}, #{code}, #{name}, #{nameforshort}, #{obuid}, #{parkingarea}, #{ordernum}, #{type}, #{address}, #{regioncode}, #{streetcode}, #{longitude}, #{latitude}, #{arrivalradius}, #{departureradius}, #{arrivalsoundfilename}, #{arrivalvideofilename}, #{departuresoundfilename}, #{departvideofilename}, #{instopledcmd}, #{outstopledcmd}, #{status}, #{mileage}, #{createtime})")
	void insert(Station st);

	@Update("update tb_station set code=#{code}, name=#{name}, nameforshort=#{nameforshort}, obuid=#{obuid}, parkingarea=#{parkingarea}, ordernum=#{ordernum}, type=#{type}, address=#{address}, regioncode=#{regioncode}, streetcode=#{streetcode}, longitude=#{longitude}, latitude=#{latitude}, arrivalradius=#{arrivalradius}, departureradius=#{departureradius}, "
			+ "arrivalsoundfilename=#{arrivalsoundfilename}, arrivalvideofilename=#{arrivalvideofilename}, departuresoundfilename=#{departuresoundfilename}, departvideofilename=#{departvideofilename}, instopledcmd=#{instopledcmd}, outstopledcmd=#{outstopledcmd}, status=#{status}, mileage=#{mileage}, createtime=#{createtime}")
	void update(Station st);

	@Delete("delete from tb_station where id = #{id}")
	void delete(int id);
	
}

