package br.univel.banco;

import java.util.List;

/**
 * @author user Classe Criada para conectividade com o banco por parte do
 *         Cliente e produto 31/10/2015 às 16:35
 */
public interface DaoGenerico<T> {

	public int inserir(T tipo);

	public int atualizar(T tipo);

	public int excluir(int tipo);

	public T buscar(int id);

	public List<T> listar();
}
