package br.fatec.testeGuit;

public class Artist {

	private String nome;
	private String location;
	
	Artist(String n, String l){
		nome = n;
		location = l;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
		
}
