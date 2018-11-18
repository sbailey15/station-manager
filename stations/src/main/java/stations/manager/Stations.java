package stations.manager;

public class Stations {

	
    private String stationId;

    private String name;
    
    private boolean hdEnabled;

    public Stations(String id, String name, boolean hdEnabled) {
    	super();
    	this.stationId =  id;
    	this.name = name;
    	this.hdEnabled = hdEnabled;
    }
    
    
    public Stations() {
    	super();
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
