package br.univel.classes;

/**
 * @author Diego Alberto Rhoden Classe dos usuarios 01/11/2015 às 13:40
 */
public class Usuarios {

	private int id;
	private String senha;
	private int idCliente;
	private String Cliente;
	
	public Usuarios(){
		
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCliente() {
		return Cliente;
	}

	public void setCliente(String cliente) {
		Cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
