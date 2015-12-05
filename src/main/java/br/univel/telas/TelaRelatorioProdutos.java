package br.univel.telas;

/**
 * @author Diego Alberto Rhoden Configura relatorio produtos
 */
import java.awt.BorderLayout;

import br.univel.relatorios.RelatorioProdutos;

@SuppressWarnings("serial")
public class TelaRelatorioProdutos extends MolduraAbstrata {

	public TelaRelatorioProdutos() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new RelatorioProdutos(), BorderLayout.CENTER);

	}

}
