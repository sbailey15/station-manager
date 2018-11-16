package stations.manager;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    
    //@Autowired
	//private StationsRepository repository;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    
    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
    
    @Test
    public void addStationReturnCreated() throws Exception {
    	
    	Stations st = new Stations();
    	st.setStationId("iheart101");

        this.mockMvc.perform(get("/stationId").param("id", "iheart101"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("id", is(st.getStationId())));
        
    }
    
    @Test
    public void updateStationReturnOk() throws Exception {
    	
    	Stations st = new Stations();
    	st.setStationId("iheart101");

        this.mockMvc.perform(get("/stationId").param("id", "iheart101"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("id", is(st.getStationId())));
        
    }
    
    @Test
    public void deleteStationWithName() throws Exception {
    	
    	String stationName = "iheartCountry";
    	
    	this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/stations/{name}", stationName)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }
    
    @Test
    public void deleteStationWithId() throws Exception {
    	
    	String stationId = "iheart102";
    	
    	this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/stations/{id}", stationId)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
