package br.univel.classes;

import java.math.BigDecimal;

/**
 * @author Diego Alberto Rhoden 01/11/2015 �s 13:45
 */

public class Vendas {

	private int cod_v;
	private int id_c;
	private int cod_p;
	private String cliente;
	private String produto;
	private BigDecimal subtotal;
	private BigDecimal valorPago;
	private BigDecimal troco;
	private String data;
	private String hora;
	private String quantidade;
	private BigDecimal unitario;

	public Vendas() {

	}

	public Vendas(int id_c, int cod_p, String cliente, String produto, BigDecimal subtotal, BigDecimal valorPago,
			BigDecimal troco, String data, String hora) {
		this.id_c = id_c;
		this.cod_p = cod_p;
		this.cliente = cliente;
		this.produto = produto;
		this.subtotal = subtotal;
		this.valorPago = valorPago;
		this.troco = troco;
		this.data = data;
		this.hora = hora;

	}

	public Vendas(int cod_v, int id_c, int cod_p, String cliente, String produto, int quantidade, BigDecimal subtotal,
			BigDecimal valorPago, BigDecimal troco, String data, String hora) {
		this.cod_v = cod_v;
		this.id_c = id_c;
		this.cliente = cliente;
		this.produto = produto;
		this.subtotal = subtotal;
		this.valorPago = valorPago;
		this.troco = troco;
		this.data = data;
		this.hora = hora;

	}

	public Vendas(int cod_v, String cliente, String produto, BigDecimal subtotal, BigDecimal valorPago,
			BigDecimal troco, String data, String hora) {
		this.cod_v = cod_v;
		this.cliente = cliente;
		this.produto = produto;
		this.subtotal = subtotal;
		this.valorPago = valorPago;
		this.troco = troco;
		this.data = data;
		this.hora = hora;

	}

	public Vendas(int cod_v, int id_c, String cliente, String produto, int quantidade, BigDecimal subtotal,
			BigDecimal valorPago, BigDecimal troco, String data, String hora) {
		this.cod_v = cod_v;
		this.id_c = id_c;
		this.cliente = cliente;
		this.produto = produto;
		this.subtotal = subtotal;
		this.valorPago = valorPago;
		this.troco = troco;
		this.data = data;
		this.hora = hora;
	}

	public Vendas(int cod_v, int id_c, String cliente, String produto, String quantidade, BigDecimal subtotal,
			BigDecimal valorPago, BigDecimal troco, String data, String hora) {

		this.cod_v = cod_v;
		this.id_c = id_c;
		this.cliente = cliente;
		this.produto = produto;
		this.quantidade = quantidade;
		this.subtotal = subtotal;
		this.valorPago = valorPago;
		this.troco = troco;
		this.data = data;
		this.hora = hora;
	}

	public Vendas(int cod_v, int id_c, int cod_p, String cliente, String produto, String quantidade,
			BigDecimal subtotal, BigDecimal valorPago, BigDecimal troco, String data, String hora) {
		this.id_c = id_c;
		this.cod_p = cod_p;
		this.cod_v = cod_v;
		this.cliente = cliente;
		this.produto = produto;
		this.quantidade = quantidade;
		this.subtotal = subtotal;
		this.valorPago = valorPago;
		this.troco = troco;
		this.data = data;
		this.hora = hora;
	}

	public Vendas(String produtos, String quantidade, BigDecimal unitario) {
		this.produto = produtos;
		this.quantidade = quantidade;
		this.unitario = unitario;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public int getCod_v() {
		return cod_v;
	}

	public int getId_c() {

		return id_c;
	}

	public String getCliente() {

		return cliente;
	}

	public int getCod_p() {

		return cod_p;
	}

	public String getProduto() {

		return produto;
	}

	public BigDecimal getSubTotal() {

		return subtotal;
	}

	public BigDecimal getValorPago() {

		return valorPago;
	}

	public BigDecimal getTroco() {

		return troco;
	}

	public String getData() {

		return data;
	}

	public String getHora() {

		return hora;
	}

}
