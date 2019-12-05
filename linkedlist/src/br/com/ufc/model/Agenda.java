package br.com.ufc.model;

import java.util.LinkedList;

public class Agenda {
	private LinkedList<Contato> agenda;
	
	public Agenda(){
		this.agenda = new LinkedList<Contato>();
	}
	
	public boolean add(Contato contato) {
		return this.agenda.add(contato);
	}
	
	public boolean remove(Contato contato) {
		return this.agenda.remove(contato);
	}
	
	public LinkedList<Contato> getAgenda(){
		return this.agenda;
	}
	
}
