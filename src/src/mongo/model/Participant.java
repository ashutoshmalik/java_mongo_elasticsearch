package src.mongo.model;

public class Participant {
	
	private String participant_age;
	private String participant_age_group; 
	private String participant_gender; 
	private String participant_name; 
	private String participant_relationship ;
	private String participant_status; 
	private String participant_type ;
	
	
	public String getParticipant_age() {
		return participant_age;
	}
	public void setParticipant_age(String participant_age) {
		this.participant_age = participant_age;
	}
	public String getParticipant_age_group() {
		return participant_age_group;
	}
	public void setParticipant_age_group(String participant_age_group) {
		this.participant_age_group = participant_age_group;
	}
	public String getParticipant_gender() {
		return participant_gender;
	}
	public void setParticipant_gender(String participant_gender) {
		this.participant_gender = participant_gender;
	}
	public String getParticipant_name() {
		return participant_name;
	}
	public void setParticipant_name(String participant_name) {
		this.participant_name = participant_name;
	}
	public String getParticipant_relationship() {
		return participant_relationship;
	}
	public void setParticipant_relationship(String participant_relationship) {
		this.participant_relationship = participant_relationship;
	}
	public String getParticipant_status() {
		return participant_status;
	}
	public void setParticipant_status(String participant_status) {
		this.participant_status = participant_status;
	}
	public String getParticipant_type() {
		return participant_type;
	}
	public void setParticipant_type(String participant_type) {
		this.participant_type = participant_type;
	}
	@Override
	public String toString() {
		return "Participant [participant_age=" + participant_age + ", participant_age_group=" + participant_age_group
				+ ", participant_gender=" + participant_gender + ", participant_name=" + participant_name
				+ ", participant_relationship=" + participant_relationship + ", participant_status="
				+ participant_status + ", participant_type=" + participant_type + "]";
	}
	
	
	
}
