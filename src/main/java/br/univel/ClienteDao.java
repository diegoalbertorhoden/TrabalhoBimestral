package br.univel;

import java.util.List;

/**
 * @author user
 * Classe Criada para conectividade com o banco por parte do Cliente
 */
public interface ClienteDao {

	public void inserir(Clientes c);

	public void atualizar(Clientes c);

	public void excluir(Clientes c);

	public Clientes buscar(int id);

	public List<Clientes> listar();
}
