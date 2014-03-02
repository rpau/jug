package org.walkmod.jug.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/twitter")
public class Twitter{

	@GET
	@Path("/findAll${query.resolve("type.name")}s/{page}/{rows}")
	public Response findAll${query.resolve("type.name")}s(@PathParam("page") int page, @PathParam("rows") int rows) {
		String str = "";

		try {
			List ${query.resolve("type.name").toLowerCase()}s = new LinkedList();
			${query.resolve("type.name").toLowerCase()}s = TwitterFacade.getInstance().findAll${query.resolve("type.name")}s(page, rows);
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(${query.resolve("type.name").toLowerCase()}s);

		} catch (Exception e) {
			Response.serverError().build();
		}
		return Response.status(200).entity(str).build();

	}
	
}