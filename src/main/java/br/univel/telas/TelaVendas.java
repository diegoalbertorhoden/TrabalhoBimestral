package br.univel.telas;

import java.awt.BorderLayout;

public class TelaVendas extends MolduraAbstrata {

	
	public TelaVendas(){
		super();
	}
	
	@Override
	protected void configura() {
		
		super.add(new MioloVendas(), BorderLayout.CENTER);

	}

}
