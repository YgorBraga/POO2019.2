package br.com.ufc.controller;

import br.com.ufc.model.Agenda;
import br.com.ufc.model.Contato;

public class AgendaController {
	Agenda agenda;
	
	public AgendaController() {
		this.agenda = new Agenda();
	}
	
	public void addContato(Contato contato) {
		this.agenda.add(contato);
	}
	
	public void rmContato(Contato contato) {
		this.agenda.remove(contato);
	}
}
