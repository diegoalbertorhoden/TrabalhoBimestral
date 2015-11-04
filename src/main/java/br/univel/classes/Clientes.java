package br.univel.classes;

public class Clientes {
	
	private int Id;
	private String telefone;
	private String endereco;
	private String cidade;
	private String email;
	private String nome;
	private String estado;
	private String genero;
	
public Clientes(){
	
	
}
	
	public Clientes(int id, String nome, String telefone, String endereco,
			String cidade, String estado, String email, String genero) {
		this.Id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco= endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
		this.genero = genero;
	}
	
	public Clientes(String nome, String telefone, String endereco,
			String cidade, String estado, String email, String genero) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco= endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
		this.genero = genero;
		
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereço(String endereço) {
		this.endereco = endereço;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
