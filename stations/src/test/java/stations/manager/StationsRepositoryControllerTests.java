package stations.manager;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;

import stations.manager.Stations;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StationsRepositoryControllerTests {

    @Autowired
    private MockMvc mockMvc;
    

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    
    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
    
    @Test
    public void addStationReturnCreated() throws Exception {
    	
    	Stations st = new Stations("iheart103","iheartPop",false);
        
        this.mockMvc.perform(post("/stations/add")
                .contentType(StationsRepositoryControllerTests.APPLICATION_JSON_UTF8)
                .content(StationsRepositoryControllerTests.convertObjectToJsonBytes(st)))
                .andExpect(status().isCreated());
        
    }
    
    @Test
    public void updateStationReturnOk() throws Exception {
    	
    	Stations st = new Stations();
    	st.setStationId("iheart1014");
    	st.setName("iheartChristmas107");
    	st.setHdEnabled(true);
    	
    	this.mockMvc.perform(post("/stations/add")
                .contentType(StationsRepositoryControllerTests.APPLICATION_JSON_UTF8)
                .content(StationsRepositoryControllerTests.convertObjectToJsonBytes(st)))
                .andExpect(status().isCreated());

    	this.mockMvc.perform(put("/stations/update{id}",st.getStationId())
                .contentType(StationsRepositoryControllerTests.APPLICATION_JSON_UTF8)
                .content(StationsRepositoryControllerTests.convertObjectToJsonBytes(st)))
                .andExpect(status().isOk());
        
    }
    
    @Test
    public void deleteStationWithName() throws Exception {
    	
    	String stationName = "iheartCountry";
    	
    	this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/stationsName/delete{name}", stationName)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }
    
    @Test
    public void deleteStationWithId() throws Exception {
    	
    	String stationId = "iheart101";
    	
    	this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/stationsId/delete{id}", stationId))
                .andExpect(status().isOk());

    }

}
