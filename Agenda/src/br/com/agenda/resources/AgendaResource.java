package br.com.agenda.resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.agenda.controller.AgendaController;
import br.com.agenda.model.Agenda;


@Path("/cliente")
public class AgendaResource {

	@GET
	@Path("/listarTodos")
	@Produces("application/json; charset=utf-8")
	public ArrayList<Agenda> listarTodos(){
		
		return new AgendaController().listarTodos();
	}
	
}
