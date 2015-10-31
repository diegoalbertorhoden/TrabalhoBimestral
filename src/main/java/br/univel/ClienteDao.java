package br.univel;

import java.util.List;

/**
 * @author user
 * Classe Criada para conectividade com o banco por parte do Cliente em 31/10/2015 às 16:35h
 */
public interface ClienteDao {

	public void inserir(Clientes c);

	public void atualizar(Clientes c);

	public void excluir(Clientes c);

	public Clientes buscar(int id);

	public List<Clientes> listar();
}
