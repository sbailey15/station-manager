package stations.manager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "station")
public class Stations {

	private @Id @GeneratedValue Long id;
	
    @Column
    private String stationId;

    @Column
    private String name;
    
    @Column
    private boolean hdEnabled;

    public Stations(String id, String name, boolean hdEnabled) {
    	this.stationId =  id;
    	this.name = name;
    	this.hdEnabled = hdEnabled;
    }
    
    public Stations() {
    	
    }
    
    public String getStationId() {
        return stationId;
    }

    public String getName() {
        return name;
    }
    
    public boolean getHdEnabled() {
    	return hdEnabled;
    }

    public void setStationId(String id) {
        this.stationId = id;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setHdEnabled(boolean enabled) {
    	this.hdEnabled = enabled;
    }
}
