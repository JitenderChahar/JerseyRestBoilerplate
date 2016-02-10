package com.dzee.gslab.dao;

import com.dzee.gslab.model.Employee;
import com.dzee.gslab.util.MongoUtil;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class EmployeeDao {

	public Employee getEmployeeDetails(String employeeId) {
		Employee emp = new Employee();
		emp.setDateOfJoining("01-02-2001");
		emp.setDepartment("Sales");
		emp.setEmail("test@example.com");
		emp.setEmployeeId("675436");
		emp.setFirstName("John");
		emp.setLastName("Smith");
		return emp;
	}

	public StringBuilder getMongoDBData() {
		DBCollection collection = MongoUtil.getCollection("some_db",
				"some_collection");

		DBCursor cursor = collection.find();
		StringBuilder data = new StringBuilder();

		long startTime = System.currentTimeMillis();
		while (cursor.hasNext()) {
			data.append(cursor.next());
		}
		long endTime = System.currentTimeMillis();

		System.out.println("Time taken : " + (endTime - startTime));

		return data;
	}
}
