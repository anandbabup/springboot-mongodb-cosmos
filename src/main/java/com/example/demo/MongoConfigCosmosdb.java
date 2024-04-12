package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories
public class MongoConfigCosmosdb {

	@Value("${cosmosdb_primaryMasterKey_m001}")
	private String key;

	@Value("${cosmosdb_name_m001}")
	private String databaseName;
	
	@Value("${cosmosdb_accname_m001}")
	private String accountId;

	@Bean
	public MongoClient mongo() {
		String uri = "mongodb://" + accountId + ":" + key + "@" + accountId
				+ ".mongo.cosmos.azure.com:10255/" + databaseName + "?ssl=true&replicaSet=globaldb&retrywrites=false&maxIdleTimeMS=120000&appName=@"
				+ accountId + "@";
		// log.debug("Connection string: " + uri);
		ConnectionString connectionString = new ConnectionString(uri);
		// log.debug("connectionString obj: "+connectionString);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();
		return MongoClients.create(mongoClientSettings);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), databaseName);
	}
}
