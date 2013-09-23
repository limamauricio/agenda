package br.com.agenda.controller;

import java.util.ArrayList;

import br.com.agenda.dao.AgendaDAO;
import br.com.agenda.model.Agenda;

public class AgendaController {
	
	public ArrayList<Agenda> listarTodos(){
		
		return AgendaDAO.getInstance().listarTodos();
		
	}
}
