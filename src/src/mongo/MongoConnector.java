package src.mongo;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoConnector {
	
	private String user = "";
	private String database = "gunviolence";
	private char[] password = {};
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
		
		MakeConnection();
	}
	
	private void MakeConnection () {
		//MongoCredential credential = MongoCredential.createCredential(user, database, password);	
		MongoClientOptions options = MongoClientOptions.builder().sslEnabled(false).build();
		mongoClient = new MongoClient(
				new ServerAddress(mongoClientURI, mongoClientPort));
	}
	
	public MongoDatabase getDatabase (String databaseName) {
		return mongoClient.getDatabase(databaseName);
	}
	
	public MongoCollection<Document> getCollection (String databaseName, String collectionName) {
		MongoDatabase database = getDatabase(databaseName);
		MongoCollection<Document> collection = database.getCollection(collectionName);		
		return collection;
	}
	
	public CodecRegistry getCustomCodecRegistry () {
		return fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
	}
	
	public void CloseConnection () {
		this.mongoClient.close();
	}
	
}














