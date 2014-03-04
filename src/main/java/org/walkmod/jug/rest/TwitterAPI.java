package org.walkmod.jug.rest;

import java.util.List;
import java.util.Collections;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.walkmod.jug.service.Twitter;
import org.walkmod.jug.model.Tweet;
import org.walkmod.jug.model.User;

@Path("/twitter")
public class TwitterAPI {

	@GET
	@Path("/findAllTweets/{page}/{rows}")
	public Response findAllTweets(@PathParam("page") int page,
			@PathParam("rows") int rows) {
		String str = "";
		try {
			List<Tweet> tweets = Collections.EMPTY_LIST;
			tweets = Twitter.getInstance().findAllTweets(page, rows);
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(tweets);
		} catch (Exception e) {
			Response.serverError().build();
		}
		return Response.status(200).entity(str).build();
	}

	@GET
	@Path("/findAllUsers/{page}/{rows}")
	public Response findAllUsers(@PathParam("page") int page,
			@PathParam("rows") int rows) {
		String str = "";
		try {
			List<User> users = Collections.EMPTY_LIST;
			users = Twitter.getInstance().findAllUsers(page, rows);
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(users);
		} catch (Exception e) {
			Response.serverError().build();
		}
		return Response.status(200).entity(str).build();
	}
}
