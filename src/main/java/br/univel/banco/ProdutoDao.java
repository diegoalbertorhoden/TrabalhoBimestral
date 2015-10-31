package br.univel.banco;

import java.util.List;

import br.univel.Produtos;
/**
 * @author user
 * Classe criada para implementacao dos codigos sql dos produtos 
 * 31/10/2015 às 16:51
 */
public interface ProdutoDao {

	public void inserir(Produtos p);
	
	public void atualizar(Produtos p);
	
	public void excluir(Produtos p);
	
	public Produtos buscar(int id);
	
	public List<Produtos> listarProdutos();
	
}
