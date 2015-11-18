package br.univel.telas;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class TelaUsuarios extends MolduraAbstrata {

	/**
	 * Create the panel.
	 */
	public TelaUsuarios() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new MioloUsuarios(), BorderLayout.CENTER);
		
	}

}
