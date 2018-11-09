package stations.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StationsController {

    private static final String template = "%s";

    
    @RequestMapping("/stationId")
	public Station getStationById(@RequestParam(value="id",defaultValue="iheart")String id) {
		// TODO
		// Update to query database for real Station
        
        List<Station> entities = new ArrayList<Station>();
        Station st = new Station();
    	st.setId(String.format(template, id));
    	return st;

	}
    
    @RequestMapping("/stationName")
	public Station getStationByName(@RequestParam(value="name",defaultValue="iheart")String name) {
		// TODO
		// Update to query database for real Station
		List<Station> entities = new ArrayList<Station>();
        Station st = new Station();
    	st.setName(String.format(template, name));
    	return  st;

	}
    
    @RequestMapping("/hdEnabled")
	public List<Station> getHdEnabledStations() {
		// TODO
		// Update to query database for real Station
		List<Station> stations = new ArrayList<Station>();
        Station st = new Station();
    	st.setName("iheart");
    	st.setHdEnabled(true);
    	stations.add(st);
    	return  stations;

	}
}
