package stations.manager;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StationsRepository {
	@Select("select * from stations")
	public List<Stations> findAll();
	
	@Select("select * from stations WHERE hd_enabled")
	public List<Stations> findAllHdEnabled();

	@Select("SELECT * FROM stations WHERE id = #{id}")
	public Stations findById(long id);

	@Delete("DELETE FROM stations WHERE id = #{id}")
	public int deleteById(long id);
	
	@Select("SELECT * FROM stations WHERE station_id = #{id}")
	public Stations findByStationId(String id);

	@Delete("DELETE FROM stations WHERE staton_id = #{id}")
	public int deleteByStationId(String id);
	
	@Select("SELECT * FROM stations WHERE station_name = #{name}")
	public Stations findByStationName(String name);

	@Delete("DELETE FROM stations WHERE stations_name = #{name}")
	public int deleteByStationName(String name);

	@Insert("INSERT INTO stations(id, station_id, station_name, hd_enabled) VALUES (#{id}, #{stationId}, #{stationName}, #{hdEnabked})")
	public int insert(Stations station);

	@Update("Update stations set name=#{name}, passport=#{passport} where id=#{id}")
	public int update(Stations station);

}

