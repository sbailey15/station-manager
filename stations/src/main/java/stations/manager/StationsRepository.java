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
	
	@Select("select * from stations WHERE hdEnabled")
	public List<Stations> findAllHdEnabled();

	@Delete("DELETE FROM stations WHERE stationId = #{stationId}")
	public int deleteById(long id);
	
	@Select("SELECT * FROM stations WHERE stationId = #{stationId}")
	public Stations findByStationId(String id);

	@Delete("DELETE FROM stations WHERE stationId = #{stationId}")
	public int deleteByStationId(String id);
	
	@Select("SELECT * FROM stations WHERE name = #{name}")
	public Stations findByStationName(String name);

	@Delete("DELETE FROM stations WHERE name = #{name}")
	public int deleteByStationName(String name);

	@Insert("INSERT INTO stations(stationId, name, hdEnabled) VALUES (#{stationId}, #{name}, #{hdEnabled})")
	public int insert(Stations station);

	@Update("Update stations set name=#{name}, stationId=#{stationId}, hdEnabled=#{hdEnabled} where stationId=#{stationId}")
	public int update(Stations station);

}

