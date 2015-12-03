//Id, código de barras, departamento (LIMPEZA, PEÇAS, ALIMENTAÇÃO, ETC), descrição, unidade (KG, UN, PCT, CX), custo (BigDecimal) 
//e margem de lucro (BigDecimal).
//BigDecimal deve ser utilizado para valores monetários. Nunca deve-se utilizar float e Double para valores monetários por causa 
//de erros de arredondamento por ponto flutuante em valores fracionários.
package br.univel.classes;

import java.math.BigDecimal;
import java.util.Locale;

public class Produtos {

	private int id, barras, quantidade;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	private String descricao, departamento, unidade;
	private BigDecimal custo, margem;

	public Produtos() {

	}

	public Produtos(int id, int barras, String descricao, String departamento, String unidade, BigDecimal custo,
			BigDecimal margem) {
		this.id = id;
		this.barras = barras;
		this.descricao = descricao;
		this.departamento = departamento;
		this.unidade = unidade;
		this.custo = custo;
		this.margem = margem;

	}

	public Produtos(int barras, String descricao, String departamento, String unidade, BigDecimal custo,
			BigDecimal margem) {
		this.barras = barras;
		this.descricao = descricao;
		this.departamento = departamento;
		this.custo = custo;
		this.margem = margem;
		this.unidade = unidade;
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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
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

	public Double CalcularMarLucrP() {
		double valor = this.custo.doubleValue() + (this.custo.doubleValue() * (this.margem.doubleValue() / 100));
		return Double.valueOf(String.format(Locale.US, "%.3f", valor));
	}

}
