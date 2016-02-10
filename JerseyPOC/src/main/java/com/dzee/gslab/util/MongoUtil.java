package com.dzee.gslab.util;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;

public class MongoUtil {

	private final static Logger logger = Logger.getLogger(MongoUtil.class);

	private static final int port = 27017;
	private static final String host = "localhost";
	private static MongoClient mongoClient = null;

	public static MongoClient getMongoClient() {
		if (mongoClient == null) {
			try {
				String dbUri = "mongodb://" + host + ":" + port;
				mongoClient = new MongoClient(new MongoClientURI(dbUri));
				logger.debug("New Mongo Client created with [" + host
						+ "] and [" + port + "]");
			} catch (UnknownHostException | MongoException e) {
				logger.error(e.getMessage());
			}
		}
		return mongoClient;
	}

	public static DB getDatabase(String dbname) {
		MongoClient mongoClient = getMongoClient();
		DB database = mongoClient.getDB(dbname);
		return database;
	}

	public static DBCollection getCollection(String dbname,
			String collectionName) {
		DB database = getDatabase(dbname);
		DBCollection collection = database.getCollection(collectionName);
		return collection;
	}
}
