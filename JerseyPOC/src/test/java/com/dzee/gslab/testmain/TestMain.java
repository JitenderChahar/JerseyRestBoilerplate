package com.dzee.gslab.testmain;

import com.dzee.gslab.util.MongoUtil;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class TestMain {

	public static void main(String[] args) {
		DBCollection collection = MongoUtil.getCollection("some_db",
				"some_Collection");
		DBCursor cursor = collection.find();
		long startTime = System.currentTimeMillis();
		while (cursor.hasNext()) {
			// System.out.println(cursor.next());
			cursor.next();
		}
		long endTime = System.currentTimeMillis();

		System.out.println("Time taken : " + (endTime - startTime));
	}

}
