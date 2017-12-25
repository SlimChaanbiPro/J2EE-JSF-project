package tn.esprit.ws;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.TravelAdvice.entities.User;
import tn.esprit.TravelAdvice.services.UserLocal;
@Path("User")
@RequestScoped
public class UserResources {

	@EJB
	private UserLocal local;

	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.TEXT_PLAIN)//on l'imite car la repose retourne un
	// status et une reponse avec la corp vide
	public Response add(User user)	{
		
		try {
		
			
			local.create(user);
			return Response.status(Status.CREATED).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}

	}
	

	

	@GET
	@Path("/add/{FirstName}/{LastName}/{Email}/{Password}/{Login}/{adress}")
	@Produces(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.TEXT_PLAIN)//on l'imite car la repose retourne un
	// status et une reponse avec la corp vide
	public Response addUser(	@PathParam("FirstName") String FirstName,
			@PathParam("LastName") String LastName,
			@PathParam("Login") String Login,
			@PathParam("Email") String Email,
			@PathParam("Password") String Password,
			@PathParam("adress") String adress) {
		try {
			User user = new User();
			
			user.setPrenom(FirstName);
			user.setNom(LastName);
			user.setEmail(Email);
			user.setLogin(Login);
			user.setPassword(Password);
			user.setAdress(adress);
			local.create(user);
			return Response.status(Status.CREATED).build();
			
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all")
	public Response getUsers() {
		System.out.println("*****slim*******");
		return Response.status(Status.OK).entity(local.findAll()).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public List<User> getUser() {
		System.out.println("*****slim*******");
		return local.findAll();
	}
	

	public UserLocal getLocal() {
		return local;
	}

	public void setLocal(UserLocal local) {
		this.local = local;
	}

	@GET
	@Path("get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") int id) {
		User u = local.find(id);
		if (u != null)

			return Response.status(Status.OK).entity(u).build();

		return Response.status(Status.NOT_FOUND).build();
	}

	
	@GET
	@Path("getL/{login}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByILogin(@PathParam("login") String login) {
		User u = local.findByLogin(login);
		if (u != null)

			return Response.status(Status.OK).entity(u).build();

		return Response.status(Status.NOT_FOUND).build();
	}
	
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteUser(@PathParam("id") int id) {
		User u = local.find(id);
		if (u != null) {
			local.delete(id);
			return Response.status(Status.OK).build();
		}

		return Response.status(Status.NOT_FOUND).build();
	}

	@PUT
	@Path("update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean updateUser(@PathParam("id") int id, User updateduser) {
	User u = new User();
	u=local.find(id);
	updateduser=u;
		return local.updateUser(updateduser);
	}

	@GET
	@Path("auth/{login}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject doAuthenticate(@PathParam("login")String login,@PathParam("password")String password) {
		User u = local.authentificate(login, password);

	return Json.createObjectBuilder()
			.add("login", u.getLogin())
			.add("password", u.getPassword())
			.add("firstName",u.getPrenom())
			.add("lastName",u.getNom())
			
			.build();

	}

	
	
	@GET
	@Path("getA/{adress}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByIadress(@PathParam("adress") String adress) {
		User u = local.findByAdress(adress);
		if (u != null)

			return Response.status(Status.OK).entity(u).build();

		return Response.status(Status.NOT_FOUND).build();
	}
}
