package br.univel.classes;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * @author Diego Alberto Rhoden
 *01/11/2015 às 13:45
 */
public class Vendas implements Serializable {
	
	private Clientes c;
	private LinkedList<Produtos> produtos;
	private GregorianCalendar data_venda;
	private double valor_total, valor_final;

}
