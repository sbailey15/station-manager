package stations.manager;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class StationRepositoryController {

    @Autowired
    private StationsRepository stRepository;

    @RequestMapping(value = "/stations/add",method = POST)
    @ResponseBody
    public ResponseEntity<String> addStation(@RequestBody Stations stationData) throws IOException {

        stRepository.insert(stationData);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/stations/update{id}")
    @ResponseBody
    public ResponseEntity<String> updateStation(@RequestBody Stations stationData,@PathVariable String id) throws IOException {
    	Stations updatedStation = stRepository.findByStationId(id);
    	if (updatedStation != null) {
    		updatedStation.setName(stationData.getName());
    		updatedStation.setHdEnabled(stationData.getHdEnabled());
    		stRepository.update(updatedStation);
    	}else {
    		stationData.setStationId(id);
    		stRepository.insert(stationData);
    		return new ResponseEntity(HttpStatus.CREATED);
    	}

        return new ResponseEntity(HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/stationsId/delete{id}")
    public ResponseEntity<String> removeStationById(@PathVariable(value = "id") String id) throws IOException {
        
        stRepository.deleteByStationId(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/stationsName/delete{name}")
    public ResponseEntity<String> removeStationByName(@PathVariable(value = "name") String name) throws IOException {
      
        stRepository.deleteByStationName(name);
        return new ResponseEntity(HttpStatus.OK);
    }
}
