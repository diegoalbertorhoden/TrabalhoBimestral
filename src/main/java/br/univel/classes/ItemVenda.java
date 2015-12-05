package br.univel.classes;

/**
 * @author Diego Alberto Rhoden Classe de itens da venda
 */
import java.math.BigDecimal;

public class ItemVenda {

	private int id;
	private int idVenda;
	private int idProduto;
	private String descricao;
	private String departamento;
	private BigDecimal vlrUnidade;
	private int qtd;
	private BigDecimal vlrTotal;

	public ItemVenda() {

	}

	public ItemVenda(int idVenda, int idProduto, String descricao, BigDecimal vlrUnidade, BigDecimal vlrTotal) {

		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.descricao = descricao;
		this.departamento = departamento;
		this.vlrUnidade = vlrUnidade;
		this.qtd = qtd;
		this.vlrTotal = vlrTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public BigDecimal getVlrUnidade() {
		return vlrUnidade;
	}

	public void setVlrUnidade(BigDecimal vlrUnidade) {
		this.vlrUnidade = vlrUnidade;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

}
