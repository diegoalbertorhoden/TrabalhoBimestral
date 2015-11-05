//Id, código de barras, categoria (LIMPEZA, PEÇAS, ALIMENTAÇÃO, ETC), descrição, unidade (KG, UN, PCT, CX), custo (BigDecimal) 
//e margem de lucro (BigDecimal).
//BigDecimal deve ser utilizado para valores monetários. Nunca deve-se utilizar float e Double para valores monetários por causa 
//de erros de arredondamento por ponto flutuante em valores fracionários.
package br.univel.classes;

import java.math.BigDecimal;

public class Produtos {

	private int id, barras;
	private String categoria, descricao, unidade;
	private BigDecimal custo, margem;

	public Produtos() {

	}

	public Produtos(int id, int barras, String categoria, String descricao,
			String unidade, BigDecimal custo, BigDecimal margem) {
		this.id = id;
		this.barras = barras;
		this.categoria = categoria;
		this.custo = custo;
		this.margem = margem;
	}

	public Produtos(int barras, String categoria, String descricao,
			String unidade, BigDecimal custo, BigDecimal margem) {
		this.barras = barras;
		this.categoria = categoria;
		this.custo = custo;
		this.margem = margem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBarras() {
		return barras;
	}

	public void setBarras(int barras) {
		this.barras = barras;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public BigDecimal getMargem() {
		return margem;
	}

	public void setMargem(BigDecimal margem) {
		this.margem = margem;
	}

}
