package stations.manager;

public class Stations {

	private int id;
	
    private String stationId;

    private String name;
    
    private boolean hdEnabled;

    public Stations(String id, String name, boolean hdEnabled) {
    	super();
    	this.stationId =  id;
    	this.name = name;
    	this.hdEnabled = hdEnabled;
    }
    
    public Stations(int id, String stationId, String name, boolean hdEnabled) {
    	super();
    	this.id = id;
    	this.stationId =  stationId;
    	this.name = name;
    	this.hdEnabled = hdEnabled;
    }
    
    public Stations() {
    	super();
    }
    
    public int getId() {
    	return id;
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
    
    public void setId(int id) {
    	this.id = id;
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
