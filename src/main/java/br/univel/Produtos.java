//Id, código de barras, categoria (LIMPEZA, PEÇAS, ALIMENTAÇÃO, ETC), descrição, unidade (KG, UN, PCT, CX), custo (BigDecimal) 
//e margem de lucro (BigDecimal).
//BigDecimal deve ser utilizado para valores monetários. Nunca deve-se utilizar float e Double para valores monetários por causa 
//de erros de arredondamento por ponto flutuante em valores fracionários.
package br.univel;

import java.math.BigDecimal;

public class Produtos {
	
	private int Id, barras;
	private String categoria, descrição;
	public Unidade unidade;
	private BigDecimal custo, margem;
	

}
