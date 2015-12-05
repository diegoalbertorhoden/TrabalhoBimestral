package br.univel.telas;

/**
 * @author Diego Alberto Rhoden Configura relatorio de vendas
 */
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
