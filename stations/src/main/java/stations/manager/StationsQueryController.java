package stations.manager;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StationsQueryController {

    private static final String template = "%s";

    
    @RequestMapping("/stationId")
	public Stations getStationById(@RequestParam(value="id",defaultValue="iheart")String id) {
		// TODO
		// Update to query database for real Station
        
        Stations st = new Stations();
    	st.setStationId(String.format(template, id));
    	return st;

	}
    
    @RequestMapping("/stationName")
	public Stations getStationByName(@RequestParam(value="name",defaultValue="iheart")String name) {
		// TODO
		// Update to query database for real Station
	
        Stations st = new Stations();
    	st.setName(String.format(template, name));
    	return  st;

	}
    
    @RequestMapping("/hdEnabled")
	public List<Stations> getHdEnabledStations() {
		// TODO
		// Update to query database for real Station
		List<Stations> stations = new ArrayList<Stations>();
        Stations st = new Stations();
    	st.setName("iheart");
    	st.setHdEnabled(true);
    	stations.add(st);
    	return  stations;

	}
}
