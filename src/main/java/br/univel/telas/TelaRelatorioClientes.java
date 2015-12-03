package br.univel.telas;

import java.awt.BorderLayout;

import br.univel.relatorios.RelatorioClientes;

@SuppressWarnings("serial")
public class TelaRelatorioClientes extends MolduraAbstrata {

	public TelaRelatorioClientes() {
		super();
	}

	@Override
	protected void configura() {

		super.add(new RelatorioClientes(), BorderLayout.CENTER);

	}

}
