package org.walkmod.jug.rest;

import java.util.List;
import java.util.Collections;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import org.walkmod.jug.service.Twitter;

import org.walkmod.jug.model.${query.resolve("type.name")};

@Path("/twitter")
public class TwitterAPI {
	

	@GET
	@Path("/${query.resolve("type.name").toLowerCase()}/{page}/{rows}")
	public Response findAll${query.resolve("type.name")}s(@PathParam("page") int page, @PathParam("rows") int rows) {
		String str = "";

		try {
			List< ${query.resolve("type.name")} > ${query.resolve("type.name").toLowerCase()}s = Collections.EMPTY_LIST;
			${query.resolve("type.name").toLowerCase()}s = Twitter.getInstance().findAll${query.resolve("type.name")}s(page, rows);
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(${query.resolve("type.name").toLowerCase()}s);

		} catch (Exception e) {
			Response.serverError().build();
		}
		return Response.status(200).entity(str).build();

	}
	
	

	
}
