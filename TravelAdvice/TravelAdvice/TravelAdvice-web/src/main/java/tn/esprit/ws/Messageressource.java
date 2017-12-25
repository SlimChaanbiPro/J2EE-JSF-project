package tn.esprit.ws;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.Message.service.MessageServiceLocal;
import tn.esprit.TravelAdvice.entities.User;
import tn.esprit.TravelAdvice.services.UserLocal;

@Path("msg")
@ViewScoped

public class Messageressource {
	@EJB
	private  MessageServiceLocal local;
	
	@EJB
	private UserLocal llocal;
	
	

		
		@DELETE
		@Path("delete/{id}")
		@Produces(MediaType.TEXT_PLAIN)
		public Response deletemessj(@PathParam("id") int id) {
			
			
				local.deleteConversation(id);
				return Response.status(Status.OK).build();

	}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("accept/{login}")
		public Response getamessj( @PathParam("login") String login) {
			User u = new User();
			u=llocal.findByLogin(login);
			int a=u.getId();
			System.out.println("*****slim*******");
			return Response.status(Status.OK).entity(local.getMessagesFor(a)).build();
		}
		
		@POST
		@Path("/send/{login1}/{login2}/{message}")
		@Consumes(MediaType.APPLICATION_JSON)
		// @Produces(MediaType.TEXT_PLAIN)//on l'imite car la repose retourne un
		// status et une reponse avec la corp vide
		public Response sendmsj(@PathParam("login1") String login,@PathParam("login2") String login1,@PathParam("message") String message)	{
			User u = new User();
			u=llocal.findByLogin(login1);
			int idSrc = u.getId();
			User u1 = new User();
			int idDest = u1.getId();
			
			try {
			
				
				local.sendMessage(idSrc, idDest, message);
				return Response.status(Status.CREATED).build();
			} catch (Exception e) {
				return Response.status(Status.BAD_REQUEST).build();
			}

		}
}
