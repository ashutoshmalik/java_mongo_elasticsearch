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
		if (state == "") state = "state";
		this.state = state;
	}
	public String getCity_or_county() {
		return city_or_county;
	}
	public void setCity_or_county(String city_or_county) {
		if (city_or_county == "") city_or_county = "city_or_county";
		this.city_or_county = city_or_county;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if (address == "") address = "address";
		this.address = address;
	}
	@Override
	public String toString() {
		return "Address [state=" + state + ", city_or_county=" + city_or_county + ", address=" + address + "]";
	}
	
}
