package br.univel.telas;

import java.awt.BorderLayout;

public class TelaProdutos extends MolduraAbstrata {

	/**
	 * Create the panel.
	 */
	public TelaProdutos() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new MioloProdutos(), BorderLayout.CENTER);
		
	}

}
