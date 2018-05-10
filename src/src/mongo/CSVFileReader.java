package src.mongo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	protected List<IncidentSchema> read(String csvFile) {
		
		List<IncidentSchema> incidentSchemaList = new ArrayList<>();
		
		try {
			File file = new File(csvFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			String[] tempArr;
			
			IncidentSchema incidentSchema;
			Address address;
			Url url;
			Location location;
			Participant participant;
			
			boolean flag = true;
			while ((line = br.readLine()) != null) {
				if (flag) {
					flag = false;
					continue;				
				}
				tempArr = line.split(delimiter);
				
				incidentSchema = new IncidentSchema();				
				incidentSchema.setIncident_id(Long.parseLong(tempArr[0]));	
				//incidentSchema.setDate(tempArr[1]);
				
				address = new Address(); 
				address.setState(tempArr[2]);
				address.setCity_or_county(tempArr[3]);
				address.setAddress(tempArr[4]);
								
				incidentSchema.setIncidentAddress(address);
				
				incidentSchema.setN_killed(Integer.parseInt(tempArr[5]));
				incidentSchema.setN_injured(Integer.parseInt(tempArr[6]));

				url = new Url();
				url.setIncident_url(tempArr[7]);
				url.setSource_url(tempArr[8]);
				url.setIncident_url_fields_missing(Boolean.parseBoolean(tempArr[9]));
				
				incidentSchema.setIncidentURL(url);
				
				incidentSchema.setCongressional_district(Integer.parseInt(tempArr[10]));
				incidentSchema.setGun_stolen(tempArr[11]);
				incidentSchema.setGun_type(tempArr[12]);
				incidentSchema.setIncident_characteristics(tempArr[13]);
				
				location = new Location();
				location.setLatitude(Double.parseDouble(tempArr[14]));
				location.setLocation_description(tempArr[15]);
				location.setLongitude(Double.parseDouble(tempArr[16]));
				
				incidentSchema.setIncidentLocation(location);
				
				incidentSchema.setN_guns_involved(Integer.parseInt(tempArr[17]));
				incidentSchema.setNotes(tempArr[18]);
				
				participant = new Participant();
				participant.setParticipant_age(tempArr[19]);
				participant.setParticipant_age_group(tempArr[20]);
				participant.setParticipant_gender(tempArr[21]);
				participant.setParticipant_name(tempArr[22]);
				participant.setParticipant_relationship(tempArr[23]);
				participant.setParticipant_status(tempArr[24]);
				participant.setParticipant_type(tempArr[25]);
				
				incidentSchema.setParticipant(participant);
				
				incidentSchema.setSources(tempArr[26]);
				incidentSchema.setState_house_district(tempArr[27]);
				incidentSchema.setState_senate_district(tempArr[28]);
				
				System.out.println(incidentSchema);
								
				incidentSchemaList.add(incidentSchema);
			}
			br.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return incidentSchemaList;
	}
}
