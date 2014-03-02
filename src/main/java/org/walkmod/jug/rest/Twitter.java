package org.walkmod.jug.rest;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.walkmod.jug.controller.TwitterFacade;
import org.walkmod.jug.model.User;

@Path("/Twitter")
public class Twitter {

	@POST
	@Path("/createUser")
	public Response createUser(@QueryParam("screenName") String screenName) {
		User user = new User(screenName);
		try {
			TwitterFacade.getInstance().createUser(user);
		} catch (Exception e) {
			Response.serverError().build();
		}
		return Response.ok().build();
	}

	@GET
	@Path("/findAllUsers/{page}/{rows}")
	public Response findAllUsers(@PathParam("page") int page, @PathParam("rows") int rows) {
		String str = "";

		try {
			List<User> users = new LinkedList<User>();
			users = TwitterFacade.getInstance().findAllUsers(page, rows);
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(users);

		} catch (Exception e) {
			Response.serverError().build();
		}
		return Response.status(200).entity(str).build();

	}
}
