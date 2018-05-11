package src.mongo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import src.mongo.model.Address;
import src.mongo.model.Location;
import src.mongo.model.Url;
import src.mongo.model.Participant;

/**
 * 
 * @author ashu
 *
 */
public class CSVFileReader {
	
	private static final String delimiter = ",";
	
	protected void insertDataFromFile(MongoDatabase database, String csvFile) {
		
		MongoCollection<Document> collection = database.getCollection("crime");
		collection.drop();
		
		try {
			File file = new File(csvFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			String[] tempArr;
			
			Document incidentSchema;
			
			boolean flag = true;
			while ((line = br.readLine()) != null) {
				if (flag) {
					flag = false;
					continue;				
				}
				tempArr = line.split(delimiter);
				System.out.println(">>" + tempArr.length);
				
				incidentSchema = new Document();
					
				if (tempArr.length >= 1) {
					if (tempArr[0] == "") tempArr[0] = "0";
					if (tempArr[0].isEmpty()) tempArr[0] = "0";
					long id = 0;
					try {
						id = Integer.parseInt(tempArr[0]);
					} catch(NumberFormatException ex) {
						id = 0;
					}
					
					incidentSchema.append("incident_id", id);
				}
				
				if (tempArr.length >= 2) {
					Date date = new Date();					
					try {
						date = new Date(tempArr[1]);
					} catch (IllegalArgumentException ex) {
					}
					
					incidentSchema.append("date", date);
				}
				
				Document address = new Document();
				if (tempArr.length >= 3) {
					address.append("state", tempArr[2]);
				}
				if (tempArr.length >= 4) {
					address.append("city_or_county", tempArr[3]);
				}
				if (tempArr.length >= 5) {
					address.append("address", tempArr[4]);
				}
								
				
				incidentSchema.append("address", address);
				
				if (tempArr.length >= 6) {
					int n_killed = 0;
					try {
						n_killed = Integer.parseInt(tempArr[5]);
					} catch (NumberFormatException ex) {
					}
					incidentSchema.append("n_killed", n_killed);
				}
				
				if (tempArr.length >= 7) {
					int n_injured = 0;
					try {
						n_injured = Integer.parseInt(tempArr[6]);
					} catch (NumberFormatException ex) {
					}
					
					incidentSchema.append("n_injured",n_injured);
				}

				Document url = new Document();
				if (tempArr.length >= 8) {
					url.append("incident_url", tempArr[7]);
				}
				if (tempArr.length >= 9) {
					url.append("source_url", tempArr[8]);
				}
				if (tempArr.length >= 10) {
					url.append("incident_url_fields_missing", tempArr[9]);
				}
				
				incidentSchema.append("url", url);
				
				if (tempArr.length >= 11) {
					int congressional_district = 0;	
					try {
						congressional_district = Integer.parseInt(tempArr[10]);
					} catch (NumberFormatException ex) {
					}
					incidentSchema.append("congressional_district", congressional_district);
				}
				
				if (tempArr.length >= 12) {
					incidentSchema.append("gun_stolen", tempArr[11]);
				}
				if (tempArr.length >= 13) {
					incidentSchema.append("gun_type", tempArr[12]);
				}
				if (tempArr.length >= 14) {
					incidentSchema.append("incident_characteristics",tempArr[13]);
				}
				
				Document location = new Document();
				if (tempArr.length >= 15) {
					location.append("latitude", tempArr[14]);
				}
				if (tempArr.length >= 16) {
					location.append("location_description", tempArr[15]);
				}
				if (tempArr.length >= 17) {
					location.append("longitude", tempArr[16]);
				}
				
				incidentSchema.append("incidentLocation", location);
				
				if (tempArr.length >= 18) {
					int n_guns_involved = 0;
					try {
						n_guns_involved = Integer.parseInt(tempArr[17]);
					} catch (Exception ex) {
					}
					incidentSchema.append("n_guns_involved", n_guns_involved);
				}
				if (tempArr.length >= 19) {
					incidentSchema.append("notes", tempArr[18]);
				}
				
				Document participant = new Document();
				
				if (tempArr.length >= 20) {
					participant.append("participant_age", tempArr[19]);
				}
				if (tempArr.length >= 21) {
					participant.append("participant_age_group", tempArr[20]);
				}
				if (tempArr.length >= 22) {
					participant.append("participant_gender", tempArr[21]);
				}
				if (tempArr.length >= 23) {
					participant.append("participant_name", tempArr[22]);
				}
				if (tempArr.length >= 24) {
					participant.append("participant_relationship", tempArr[23]);
				}
				if (tempArr.length >= 25) {
					participant.append("participant_status", tempArr[24]);
				}
				if (tempArr.length >= 26) {
					participant.append("participant_type", tempArr[25]);
				}

				incidentSchema.append("participant", participant);
				
				if (tempArr.length >= 27) {
					incidentSchema.append("sources", tempArr[26]);
				}
				if (tempArr.length >= 28) {
					incidentSchema.append("state_house_district", tempArr[27]);
				}
				if (tempArr.length >= 29) {
					incidentSchema.append("state_senate_district", tempArr[28]);
				}
				
				//System.out.println(incidentSchema);
				
				collection.insertOne(incidentSchema);
			}
			br.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
