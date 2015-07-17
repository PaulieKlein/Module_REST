package com.bankonet.resource;

import com.bankonet.model.*;
import com.bankonet.service.EmployeService;
import com.bankonet.jaxrs.*;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;


@Path("/Employes")
public class EmployeResource {

	@EJB private EmployeService employeService; 
	
	public Response Reponse(String reponse) {
		ResponseBuilder builder = Response.ok(reponse);
		builder.language("fr").header("Content-type", "text/html");
		return builder.build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<Employe> employes = new ArrayList<Employe>();
		
		employes = employeService.findAll();

		ResponseBuilder builder = Response.status(200).entity(employes);
		return  builder.build();

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") @DefaultValue("123") Integer id) {
		Employe emp = new Employe();
		try {
		emp = employeService.employeId(id);
		ResponseBuilder builder = Response.status(200).entity(emp);
		return  builder.build();
		}
		catch (Exception e) {
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
		
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(Employe employe) {

		Employe emp = new Employe();
		try{

			emp = employeService.createEmploye(employe);
			ResponseBuilder builder = Response.status(200).entity(emp);
			return  builder.build();
		}catch(Exception e){
			e.printStackTrace();
			throw new WebApplicationException(Status.BAD_REQUEST);
		} 

		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response put(@FormParam("id") int id,Employe employe) {
		Employe emp= new Employe();
		try{
			emp = employeService.modifEmploye(id, employe);
			
		}catch (Exception e){Reponse("404 Bad Request");}
		
		ResponseBuilder builder = Response.status(200).entity(employe);
		return  builder.build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") @DefaultValue("123") int id) {

		try{
			
			employeService.deleteEmploye(id);    
		     
  	} catch(Exception e){
  		e.printStackTrace();
  		Reponse("404 not Found");
  		
  	} 
  
		
	
		}
	}
