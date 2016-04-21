/* 
  Copyright (C) 2013 Raquel Pau and Albert Coroleu.
 
 Walkmod is free software: you can redistribute it and/or modify
 it under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 
 Walkmod is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.
 
 You should have received a copy of the GNU Lesser General Public License
 along with Walkmod.  If not, see <http://www.gnu.org/licenses/>.*/

package org.walkmod.jug.rest;

import java.util.List;
import java.util.Collections;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.walkmod.jug.service.Twitter;
import org.walkmod.jug.model.Tweet;
import org.walkmod.jug.model.User;

@Path("/twitter")
public class TwitterAPI {
   @GET
   @Path("/tweet/{page}/{rows}")
   public Response findAllTweets(@PathParam("page") int page, @PathParam("rows") int rows) {
      String str = "";
      try {
         List<Tweet> tweets = Collections.emptyList();
         tweets = Twitter.getInstance().findAllTweets(page, rows);
         ObjectMapper mapper = new ObjectMapper();
         str = mapper.writeValueAsString(tweets);
      } catch (Exception e) {
         Response.serverError().build();
      }
      return Response.status(200).entity(str).build();
   }

   @GET
   @Path("/user/{page}/{rows}")
   public Response findAllUsers(@PathParam("page") int page, @PathParam("rows") int rows) {
      String str = "";
      try {
         List<User> users = Collections.emptyList();
         users = Twitter.getInstance().findAllUsers(page, rows);
         ObjectMapper mapper = new ObjectMapper();
         str = mapper.writeValueAsString(users);
      } catch (Exception e) {
         Response.serverError().build();
      }
      return Response.status(200).entity(str).build();
   }

}
