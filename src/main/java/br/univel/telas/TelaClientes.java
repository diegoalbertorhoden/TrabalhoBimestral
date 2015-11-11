package br.univel.telas;

import java.awt.BorderLayout;

public class TelaClientes extends MolduraAbstrata {

	/**
	 * Não consegui inserir o botão de fechar, resolvi investir no Miolo que o professor passou, porém que eu faltei na aula..
	 */
	public TelaClientes() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new MioloClientes(), BorderLayout.CENTER);
		
	}

}
