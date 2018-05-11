package src.mongo.model;

import org.bson.Document;

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
		try {
			this.latitude = Double.parseDouble(latitude);
		} catch (NumberFormatException ex) {
			this.latitude = 0.0;
		}
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		if (longitude == "" ) longitude = ("0.0");
		if (longitude.isEmpty()) longitude = ("0.0");
		try {
			this.longitude = Double.parseDouble(longitude);
		} catch (Exception ex) {
			this.longitude = 0.0;
		}
	}
	public String getLocation_description() {
		return location_description;
	}
	public void setLocation_description(String location_description) {
		this.location_description = location_description;
	}
	@Override
	public String toString() {
		return "Location [latitude=" + latitude + ", longitude=" + longitude + ", location_description="
				+ location_description + "]";
	}
	
}
