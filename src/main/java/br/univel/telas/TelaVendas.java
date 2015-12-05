package br.univel.telas;

/**
 * @author Diego Alberto Rhoden configuracao para tela vendas
 */
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class TelaVendas extends MolduraAbstrata {

	public TelaVendas() {
		super();
	}

	@Override
	protected void configura() {

		super.add(new MioloVendas(), BorderLayout.CENTER);

	}

}
