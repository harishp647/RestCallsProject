package com.telusko.RestCallsProject;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("aliens")

public class AlienResource {

	AlienRepository repo = new AlienRepository();

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

	public List<Alien> getAliens() {
		return repo.getAliens();
	}
	
	@Path("alien/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Alien getAlien(@PathParam ("id") int id)
	{
		return repo.getAlien(id);
	}
	
	@Path("aliensdata")
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void createAlien(Alien a1)
	{
		 repo.createAlien(a1);
		 
	}
	@Path("putaliensdata")
	@PUT
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	
	public Object updateAlien(Alien a1)
	{
		return  repo.updateAlienData(a1);
		
	}
	@Path("deletealiensdata/{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Alien deleteAlien(@PathParam("id")int id)
	{
		Alien a = repo.getAlien(id);
		if(a.getId()!=0) {
		 repo.deleteAlienData(id);
		}
		return a;
		
	}
	
	
	}
	

