package br.com.ufc.controller;

import java.util.LinkedList;

import br.com.ufc.model.Agenda;
import br.com.ufc.model.Contato;
import br.com.ufc.model.Telefone;
import br.com.ufc.model.Email;

public class AgendaController {
	private Agenda agenda;
	
	public AgendaController() {
		this.agenda = new Agenda();
	}
	
	public void addContato(Contato contato) {
		this.agenda.add(contato);
	}
	
	public void addContato(String nome, String telefone, String email) {
		Contato contato = new Contato();
		Telefone numero = new Telefone();
		Email eMail = new Email();
		numero.setNumero(telefone);
		eMail.setEmail(email);
		contato.setNome(nome);
		contato.addTelefone(numero);
		contato.addEmail(eMail);
		this.agenda.add(contato);
	}
	
	public boolean rmContato(Contato contato) {
		return this.agenda.remove(contato);
	}
	
	public boolean rmContato(String nome) {
		LinkedList<Contato> agenda = this.agenda.getAgenda(); 
		for(int i = 0; i < agenda.size(); i++) {
			if(agenda.get(i).getNome().equals(nome)) {
				return rmContato(agenda.get(i));
			}
		}
		return false;
	}
	
	public void attContato(Contato oldContato, Contato newContato) {
		this.agenda.att(oldContato, newContato);
	}
	
	public LinkedList<Contato> getAgenda() {
		return this.agenda.getAgenda();
	}
	
}
