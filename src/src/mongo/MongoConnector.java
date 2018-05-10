package src.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnector {
	
	private String user = "ashu";
	private String database = "gunviolence";
	private char[] password = {'a','s','h','u'};
	private MongoClient mongoClient;
	private int mongoClientPort = 27017;
	private String mongoClientURI = "localhost";
	
	public MongoConnector() {
		this.MakeConnection();		
	}
	
	public MongoConnector (String user, char[] password, String database, String mongoClientURI, int mongoClientPort) {		
		
		this.user = user;
		this.password = password;
		this.database = database;
		this.mongoClientURI = mongoClientURI;
		this.mongoClientPort = mongoClientPort;
		
		this.MakeConnection();		
	}
	
	private void MakeConnection () {
		MongoCredential credential = MongoCredential.createCredential(user, database, password);	
		MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();
		mongoClient = new MongoClient(
				new ServerAddress(mongoClientURI, mongoClientPort), credential, options);
	}
	
	public MongoDatabase getDatabase (String databaseName) 
	{
		return mongoClient.getDatabase(databaseName);
	}
	
	public MongoCollection<Document> getCollection (String databaseName, String collectionName) {
		MongoDatabase database = getDatabase(databaseName);
		MongoCollection<Document> collection = database.getCollection(collectionName);		
		return collection;
	}
	
}














