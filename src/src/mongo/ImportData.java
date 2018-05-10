package src.mongo;

import com.mongodb.client.MongoDatabase;

public class ImportData {

	public static void main(String[] args) {
		
		MongoConnector connector = new MongoConnector();
		MongoDatabase database = connector.getDatabase("gunviolence");
		if (database.getCollection("crime") == null) database.createCollection("crime");
		
		CSVFileReader fileReader = new CSVFileReader();
		String csvFile = "C:/Users/eashmik/Downloads/gun-violence-data/gun-violence-data_01-2013_03-2018.csv";
		fileReader.read(csvFile);
		
		//Close the database connection
		connector.CloseConnection();
	}

}
