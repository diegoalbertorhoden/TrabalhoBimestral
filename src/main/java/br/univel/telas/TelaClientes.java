package br.univel.telas;

import java.awt.BorderLayout;

public class TelaClientes extends MolduraAbstrata {

	/**
	 * N�o consegui inserir o bot�o de fechar, resolvi investir no Miolo que o professor passou, por�m que eu faltei na aula..
	 */
	public TelaClientes() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new MioloClientes(), BorderLayout.CENTER);
		
	}

}
