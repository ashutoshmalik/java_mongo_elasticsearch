package src.mongo.model;

public class Url {
	
	private String incident_url;
	private String source_url;
	private boolean incident_url_fields_missing; 
	
	public String getIncident_url() {
		return incident_url;
	}
	public void setIncident_url(String incident_url) {
		this.incident_url = incident_url;
	}
	public String getSource_url() {
		return source_url;
	}
	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}
	public boolean isIncident_url_fields_missing() {
		return incident_url_fields_missing;
	}
	public void setIncident_url_fields_missing(boolean incident_url_fields_missing) {
		this.incident_url_fields_missing = incident_url_fields_missing;
	}
	
}