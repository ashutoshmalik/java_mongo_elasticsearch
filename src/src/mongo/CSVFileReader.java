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
				System.out.println(">>" + tempArr.length);
				
//				System.out.println( ">> "
//									    + tempArr[0] + ", " + tempArr[1] + ", " + tempArr[2] + ", "+ tempArr[3] + ", "+ tempArr[4] + ", "
//				                        + tempArr[5] + ", " + tempArr[6] + ", " + tempArr[7] + ", "+ tempArr[8] + ", "+ tempArr[9] + ", "
//						                + tempArr[10] + ", "+ tempArr[11] + ", "+ tempArr[12] + ", "+ tempArr[13] + ", "+ tempArr[14] + ", "
//						                + tempArr[15] + ", "+ tempArr[16] + ", "+ tempArr[17] + ", "+ tempArr[18] + ", "+ tempArr[19] + ", "
//						                + tempArr[20] + ", "+ tempArr[21] + ", "+ tempArr[22] + ", "+ tempArr[23] + ", "+ tempArr[24] + ", "
//				                        + tempArr[25] + ", "+ tempArr[26] + ", "
//					              );
//				
				if (tempArr.length == 1 && tempArr[0] != null) incidentSchema.setIncident_id(tempArr[0]);	
				if (tempArr.length == 2 && tempArr[1] != null) incidentSchema.setDate(tempArr[1]);
				
				address = new Address(); 
				if (tempArr.length == 3 && tempArr[2] != null)address.setState(tempArr[2]);
				if (tempArr.length == 4 && tempArr[3] != null)address.setCity_or_county(tempArr[3]);
				if (tempArr.length == 5 && tempArr[4] != null)address.setAddress(tempArr[4]);
								
				incidentSchema.setIncidentAddress(address);
				
				if (tempArr.length == 6 && tempArr[5] != null)incidentSchema.setN_killed(tempArr[5]);
				if (tempArr.length == 7 && tempArr[6] != null)incidentSchema.setN_injured(tempArr[6]);

				url = new Url();
				if (tempArr.length == 8 && tempArr[7] != null)url.setIncident_url(tempArr[7]);
				if (tempArr.length == 9 && tempArr[8] != null)url.setSource_url(tempArr[8]);
				if (tempArr.length == 10 && tempArr[9] != null)url.setIncident_url_fields_missing(tempArr[9]);
				
				incidentSchema.setIncidentURL(url);
				
				if (tempArr.length == 11 && tempArr[10] != null)incidentSchema.setCongressional_district(tempArr[10]);
				if (tempArr.length == 12 && tempArr[11] != null)incidentSchema.setGun_stolen(tempArr[11]);
				if (tempArr.length == 13 && tempArr[12] != null)incidentSchema.setGun_type(tempArr[12]);
				if (tempArr.length == 14 && tempArr[13] != null)incidentSchema.setIncident_characteristics(tempArr[13]);
				
				location = new Location();
				if (tempArr.length == 15 && tempArr[14] != null)location.setLatitude(tempArr[14]);
				if (tempArr.length == 16 && tempArr[15] != null)location.setLocation_description(tempArr[15]);
				if (tempArr.length == 17 && tempArr[16] != null)location.setLongitude(tempArr[16]);
				
				incidentSchema.setIncidentLocation(location);
				
				if (tempArr.length == 18 && tempArr[17] != null)incidentSchema.setN_guns_involved(tempArr[17]);
				if (tempArr.length == 19 && tempArr[18] != null)incidentSchema.setNotes(tempArr[18]);
				
				participant = new Participant();
				if (tempArr.length == 20 && tempArr[19] != null)participant.setParticipant_age(tempArr[19]);
				if (tempArr.length == 21 && tempArr[20] != null)participant.setParticipant_age_group(tempArr[20]);
				if (tempArr.length == 22 && tempArr[21] != null)participant.setParticipant_gender(tempArr[21]);
				if (tempArr.length == 23 && tempArr[22] != null)participant.setParticipant_name(tempArr[22]);
				if (tempArr.length == 24 && tempArr[23] != null)participant.setParticipant_relationship(tempArr[23]);
				if (tempArr.length == 25 && tempArr[24] != null)participant.setParticipant_status(tempArr[24]);
				if (tempArr.length == 26 && tempArr[25] != null)participant.setParticipant_type(tempArr[25]);

				incidentSchema.setParticipant(participant);
				
				if (tempArr.length == 27 && tempArr[26] != null)incidentSchema.setSources(tempArr[26]);
				if (tempArr.length == 28 && tempArr[27] != null)incidentSchema.setState_house_district(tempArr[27]);
				if (tempArr.length == 29 && tempArr[28] != null)incidentSchema.setState_senate_district(tempArr[28]);
				
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
