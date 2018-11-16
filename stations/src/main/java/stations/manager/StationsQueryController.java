package stations.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StationsQueryController {

    private static final String template = "%s";

    @Autowired
    private StationsRepository stRepository;
    
    @RequestMapping("/stationId")
	public Stations getStationById(@RequestParam(value="id",defaultValue="iheart")String id) {
		Stations st = stRepository.findByStationId(id);
    	return st;

	}
    
    @RequestMapping("/stationName")
	public Stations getStationByName(@RequestParam(value="name",defaultValue="iheart")String name) {
		Stations st = stRepository.findByStationName(name);
    	return  st;

	}
    
    @RequestMapping("/hdEnabled")
	public List<Stations> getHdEnabledStations() {
		
    	List<Stations> stations = stRepository.findAllHdEnabled();
    	return  stations;

	}
}
