package src.mongo.model;

/**
 * 
 * @author ashu
 *
 */
public class Address {
	
	private String state;
	private String city_or_county;
	private String address;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity_or_county() {
		return city_or_county;
	}
	public void setCity_or_county(String city_or_county) {
		this.city_or_county = city_or_county;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
