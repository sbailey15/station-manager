/*
 * Copyright 2016 the original author or auth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StationsQueryControllerTests {

    @Autowired
    private MockMvc mockMvc;

    
    @Test
    public void paramIdShouldReturnStationWithId() throws Exception {
    	
    	Stations st = new Stations();
    	st.setStationId("iheart101");

        this.mockMvc.perform(get("/stationId").param("id", "iheart101"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("id", is(st.getStationId())));
        
    }
    
    @Test
    public void paramNameShouldReturnStationWithName() throws Exception {
    	
    	Stations st = new Stations();
    	st.setName("iheartCountry");

        this.mockMvc.perform(get("/stationName").param("name", "iheartCountry"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("name", is(st.getName())));
    }
    
    @Test
    public void noParamReturnHdStations() throws Exception {
    	
    	Stations st = new Stations();
    	st.setName("iheart");

        this.mockMvc.perform(get("/hdEnabled"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name",is(st.getName())));
    }

}
