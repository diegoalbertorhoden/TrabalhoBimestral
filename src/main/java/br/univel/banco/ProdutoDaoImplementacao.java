package br.univel.banco;

import java.util.List;

import br.univel.classes.Produtos;

/**
 * @author user
 *
 */
public abstract class ProdutoDaoImplementacao implements DaoGenerico<Produtos> {

	@Override
	public void inserir(Produtos p) {

	}

	@Override
	public void atualizar(Produtos p) {

	}

	public void excluir(Produtos p) {

	}

	// public Produtos buscar(int id) {
	//
	// return null;
	// }

	public List<Produtos> listarProdutos() {

		return null;
	}

}
