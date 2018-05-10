package src.mongo;

import java.util.Date;

import src.mongo.model.IncidentAddress;
import src.mongo.model.IncidentLocation;
import src.mongo.model.IncidentURL;
import src.mongo.model.Participant;

/**
 * 
 * @author ashu
 *
 */
public class IncidentSchema {
	
	private long incident_id; 
    private Date date; 
	private IncidentAddress incidentAddress;
	
	private int n_killed;
	private int n_injured; 
	
	private IncidentURL incidentURL;
	
	private int congressional_district; 
	private String gun_stolen;
	private String gun_type;
	private String incident_characteristics;
	
	private IncidentLocation incidentLocation;
	
	private int n_guns_involved; 
	private String notes; 

	private Participant participant;
	
	private String sources ;
	private String state_house_district ;
	private String state_senate_district ;
	
	public long getIncident_id() {
		return incident_id;
	}
	public void setIncident_id(long incident_id) {
		this.incident_id = incident_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public IncidentAddress getIncidentAddress() {
		return incidentAddress;
	}
	public void setIncidentAddress(IncidentAddress incidentAddress) {
		this.incidentAddress = incidentAddress;
	}
	public int getN_killed() {
		return n_killed;
	}
	public void setN_killed(int n_killed) {
		this.n_killed = n_killed;
	}
	public int getN_injured() {
		return n_injured;
	}
	public void setN_injured(int n_injured) {
		this.n_injured = n_injured;
	}
	public IncidentURL getIncidentURL() {
		return incidentURL;
	}
	public void setIncidentURL(IncidentURL incidentURL) {
		this.incidentURL = incidentURL;
	}
	public int getCongressional_district() {
		return congressional_district;
	}
	public void setCongressional_district(int congressional_district) {
		this.congressional_district = congressional_district;
	}
	public String getGun_stolen() {
		return gun_stolen;
	}
	public void setGun_stolen(String gun_stolen) {
		this.gun_stolen = gun_stolen;
	}
	public String getGun_type() {
		return gun_type;
	}
	public void setGun_type(String gun_type) {
		this.gun_type = gun_type;
	}
	public String getIncident_characteristics() {
		return incident_characteristics;
	}
	public void setIncident_characteristics(String incident_characteristics) {
		this.incident_characteristics = incident_characteristics;
	}
	public IncidentLocation getIncidentLocation() {
		return incidentLocation;
	}
	public void setIncidentLocation(IncidentLocation incidentLocation) {
		this.incidentLocation = incidentLocation;
	}
	public int getN_guns_involved() {
		return n_guns_involved;
	}
	public void setN_guns_involved(int n_guns_involved) {
		this.n_guns_involved = n_guns_involved;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Participant getParticipant() {
		return participant;
	}
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	public String getSources() {
		return sources;
	}
	public void setSources(String sources) {
		this.sources = sources;
	}
	public String getState_house_district() {
		return state_house_district;
	}
	public void setState_house_district(String state_house_district) {
		this.state_house_district = state_house_district;
	}
	public String getState_senate_district() {
		return state_senate_district;
	}
	public void setState_senate_district(String state_senate_district) {
		this.state_senate_district = state_senate_district;
	}
	
}
