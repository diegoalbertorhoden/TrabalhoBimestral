package br.univel.banco;

import java.util.List;

import br.univel.Clientes;

/**
 * @author user
 * Classe Criada para conectividade com o banco por parte do Cliente e produto
 * 31/10/2015 às 16:35
 */
public interface DaoGenerico <T>{

	public void inserir(T tipo);

	public void atualizar(T tipo);

	public void excluir(int tipo);

	public Clientes buscar(int id);

	public List<Clientes> listar();
}
