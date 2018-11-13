package stations.manager;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import stations.manager.Stations;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StationsRepositoryControllerTests {

    @Autowired
    private MockMvc mockMvc;

    
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
    	
    	Stations st = new Stations();
    	st.setName("iheartCountry");

        this.mockMvc.perform(get("/stationName").param("name", "iheartCountry"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("name", is(st.getName())));
    }
    
    @Test
    public void deleteStationWithId() throws Exception {
    	
    	Stations st = new Stations();
    	st.setName("iheart");

        this.mockMvc.perform(get("/hdEnabled"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name",is(st.getName())));
    }

}
