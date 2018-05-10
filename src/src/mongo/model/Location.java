package src.mongo.model;

/**
 * 
 * @author ashu
 *
 */
public class Location {
	
	private double latitude; 
	private double longitude;
	private String location_description;
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		if (latitude == "" ) latitude = ("0.0");
		if (latitude.isEmpty()) latitude = ("0.0");
		this.latitude = Double.parseDouble(latitude);
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		if (longitude == "" ) longitude = ("0.0");
		if (longitude.isEmpty()) longitude = ("0.0");
		this.longitude = Double.parseDouble(longitude);
	}
	public String getLocation_description() {
		return location_description;
	}
	public void setLocation_description(String location_description) {
		this.location_description = location_description;
	}
	
}
