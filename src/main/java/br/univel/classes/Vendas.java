package br.univel.classes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * @author Diego Alberto Rhoden 01/11/2015 às 13:45
 */
public class Vendas implements Serializable {

	private Clientes c;
	private LinkedList<Produtos> produtos;
	private GregorianCalendar data_venda;
	private double valor_total, valor_final;
	public Vendas(int int1, int int2, String string, String string2,
			BigDecimal bigDecimal, BigDecimal bigDecimal2,
			BigDecimal bigDecimal3, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}
	public Vendas(int int1, int int2, int int3, String string, String string2,
			BigDecimal bigDecimal, BigDecimal bigDecimal2,
			BigDecimal bigDecimal3, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}
	public int getId_c() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getCliente() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getId_produto() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getProduto() {
		// TODO Auto-generated method stub
		return null;
	}
	public BigDecimal getvTotal() {
		// TODO Auto-generated method stub
		return null;
	}
	public BigDecimal getvPago() {
		// TODO Auto-generated method stub
		return null;
	}
	public BigDecimal getTroco() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getData() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getHora() {
		// TODO Auto-generated method stub
		return null;
	}

}
