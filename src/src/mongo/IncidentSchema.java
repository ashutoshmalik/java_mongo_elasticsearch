package src.mongo;

import java.util.Date;

import src.mongo.model.Address;
import src.mongo.model.Location;
import src.mongo.model.Url;
import src.mongo.model.Participant;

/**
 * 
 * @author ashu
 *
 */
public class IncidentSchema {
	
	private long incident_id; 
    private Date date; 
	private Address incidentAddress;
	
	private int n_killed;
	private int n_injured; 
	
	private Url incidentURL;
	
	private int congressional_district; 
	private String gun_stolen;
	private String gun_type;
	private String incident_characteristics;
	
	private Location incidentLocation;
	
	private int n_guns_involved; 
	private String notes; 

	private Participant participant;
	
	private String sources ;
	private String state_house_district ;
	private String state_senate_district ;
	
	public long getIncident_id() {
		return incident_id;
	}
	public void setIncident_id(String incident_id) {
		if (incident_id == "") incident_id = "0";
		if (incident_id.isEmpty()) incident_id = "0";
		this.incident_id = Integer.parseInt(incident_id);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = new Date(date);
	}
	public Address getIncidentAddress() {
		return incidentAddress;
	}
	public void setIncidentAddress(Address incidentAddress) {
		this.incidentAddress = incidentAddress;
	}
	public int getN_killed() {
		return n_killed;
	}
	public void setN_killed(String n_killed) {
		if (n_killed == "") n_killed = "0";
		if (n_killed.isEmpty()) n_killed = "0";
		this.n_killed = Integer.parseInt(n_killed);
	}
	public int getN_injured() {
		return n_injured;
	}
	public void setN_injured(String n_injured) {
		if (n_injured == "") n_injured = "0";
		if (n_injured.isEmpty()) n_injured = "0";
		this.n_injured = Integer.parseInt(n_injured);
	}
	public Url getIncidentURL() {
		return incidentURL;
	}
	public void setIncidentURL(Url incidentURL) {
		this.incidentURL = incidentURL;
	}
	public int getCongressional_district() {
		return congressional_district;
	}
	public void setCongressional_district(String congressional_district) {
		if (congressional_district == "") congressional_district = "0";
		if (congressional_district.isEmpty()) congressional_district = "0";
		this.congressional_district = Integer.parseInt(congressional_district);
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
	public Location getIncidentLocation() {
		return incidentLocation;
	}
	public void setIncidentLocation(Location incidentLocation) {
		this.incidentLocation = incidentLocation;
	}
	public int getN_guns_involved() {
		return n_guns_involved;
	}
	public void setN_guns_involved(String n_guns_involved) {
		if (n_guns_involved == "" ) n_guns_involved = "0";
		if (n_guns_involved.isEmpty()) n_guns_involved = "0";
		this.n_guns_involved = Integer.parseInt(n_guns_involved);
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
	
	@Override
	public String toString() {
		return "IncidentSchema [incident_id=" + incident_id + ", date=" + date + ", incidentAddress=" + incidentAddress
				+ ", n_killed=" + n_killed + ", n_injured=" + n_injured + ", incidentURL=" + incidentURL
				+ ", congressional_district=" + congressional_district + ", gun_stolen=" + gun_stolen + ", gun_type="
				+ gun_type + ", incident_characteristics=" + incident_characteristics + ", incidentLocation="
				+ incidentLocation + ", n_guns_involved=" + n_guns_involved + ", notes=" + notes + ", participant="
				+ participant + ", sources=" + sources + ", state_house_district=" + state_house_district
				+ ", state_senate_district=" + state_senate_district + "]";
	}
	
	
}
