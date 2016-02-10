package com.dzee.gslab.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dzee.gslab.dao.EmployeeDao;

@Path("employee")
public class EmployeeResource {
	private EmployeeDao employeeDao = new EmployeeDao();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployeeDetail(
			@QueryParam("employeeId") String employeeId) {
		if (employeeId == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(employeeDao.getEmployeeDetails(employeeId)).build();
	}

	@GET
	@Path("mongoData")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMongoDBData() {
		return employeeDao.getMongoDBData().toString();
	}

}
