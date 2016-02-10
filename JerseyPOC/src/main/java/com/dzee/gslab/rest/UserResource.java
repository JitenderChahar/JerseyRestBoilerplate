package com.dzee.gslab.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dzee.gslab.dao.UserDao;

@Path("/user")
public class UserResource {
	private UserDao userDao = new UserDao();

	@GET
	@Path("/{username}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getUserDetail(@PathParam("username") String username) {
		if (username == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(userDao.getUserDetails(username)).build();
	}

}
