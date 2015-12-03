package br.univel.telas;

import java.awt.BorderLayout;

import br.univel.relatorios.RelatorioVendas;

@SuppressWarnings("serial")
public class TelaRelatorioVendas extends MolduraAbstrata {

	public TelaRelatorioVendas() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new RelatorioVendas(), BorderLayout.CENTER);

	}

}
