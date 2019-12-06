package br.com.ufc.model;

import java.util.LinkedList;

public class Contato {
	private String nome;
	private LinkedList<Telefone> telefones;
	private LinkedList<Email> emails;
	
	public Contato(){
		this.telefones = new LinkedList<Telefone>();
		this.emails = new LinkedList<Email>();
	}
	
	public Contato(String nome){
		this.nome = nome;
		this.telefones = new LinkedList<Telefone>();
		this.emails = new LinkedList<Email>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean addTelefone(Telefone telefone) {
		return this.telefones.add(telefone);
	}
	
	public boolean rmTelefone(Telefone telefone) {
		return this.telefones.remove(telefone);
	}
	
	public boolean addEmail(Email email) {
		return this.emails.add(email);
	}
	
	public boolean rmEmail(Email email) {
		return this.emails.remove(email);
	}
	
	public LinkedList<Telefone> getTelefones(){
		return this.telefones;
	}
	
	public LinkedList<Email> getEmails(){
		return this.emails;
	}
}
