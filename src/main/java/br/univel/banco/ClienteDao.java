package br.univel.banco;

import java.util.List;

import br.univel.Clientes;

/**
 * @author user
 * Classe Criada para conectividade com o banco por parte do Cliente
 * 31/10/2015 às 16:35
 */
public interface ClienteDao {

	public void inserir(Clientes c);

	public void atualizar(Clientes c);

	public void excluir(Clientes c);

	public Clientes buscar(int id);

	public List<Clientes> listar();
}
