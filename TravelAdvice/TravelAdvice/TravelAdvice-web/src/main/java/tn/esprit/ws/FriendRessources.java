package tn.esprit.ws;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.ListAmis.service.FriendshipLocal;
import tn.esprit.Bean.FreindBean;
import tn.esprit.TravelAdvice.entities.Friendship;
import tn.esprit.TravelAdvice.entities.User;
import tn.esprit.TravelAdvice.services.UserLocal;

@Path("Amis")
@RequestScoped
public class FriendRessources {
	@EJB
	private FriendshipLocal local;
	@EJB
	private UserLocal llocal;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("inv/{login}")
	public Response getrequest( @PathParam("login") String login) {
		User u = new User();
		u=llocal.findByLogin(login);
		int a=u.getId();
		System.out.println("*****slim*******");
		return Response.status(Status.OK).entity(local.getRequestFor(a)).build();
	}
	
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deletefriend(@PathParam("id" )int id ) {
	;
	
	    

			local.deleteFriend(id);
			return Response.status(Status.OK).build();
		

		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("iamis/{login}")
	public Response getAmis( @PathParam("login") String login) {
		User u = new User();
		u=llocal.findByLogin(login);
		int a=u.getId();
		System.out.println("*****slim*******");
		return Response.status(Status.OK).entity(local.getFriendsList(a)).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("accept/{login}")
	public Response getaccepter( @PathParam("login") String login) {
		User u = new User();
		u=llocal.findByLogin(login);
		int a=u.getId();
		System.out.println("*****slim*******");
		return Response.status(Status.OK).entity(local.acceptFriendRequest(a)).build();
	}
	
	
	

}
