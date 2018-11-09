package stations.manager;

public class Station {
	
	private String id = null;
	private String name =  null;
	private String callSign = null;
	private boolean hdEnabled = false;
	
	public Station() {
		
	}
	
	public Station(String id,String name,String callSign, boolean hdEnabled) {
		this.id = id;
		this.name =  name;
		this.callSign = callSign;
		this.hdEnabled = hdEnabled;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCallSign() {
		return this.callSign;
	}
	
	public boolean isHdEnabled() {
		return this.hdEnabled;
	}
	
	public boolean getHdEnabled() {
		return this.hdEnabled;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	
	public void setHdEnabled(boolean hdEnabled) {
		this.hdEnabled = hdEnabled;
	}

}
