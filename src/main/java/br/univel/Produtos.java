//Id, c�digo de barras, categoria (LIMPEZA, PE�AS, ALIMENTA��O, ETC), descri��o, unidade (KG, UN, PCT, CX), custo (BigDecimal) 
//e margem de lucro (BigDecimal).
//BigDecimal deve ser utilizado para valores monet�rios. Nunca deve-se utilizar float e Double para valores monet�rios por causa 
//de erros de arredondamento por ponto flutuante em valores fracion�rios.
package br.univel;

import java.math.BigDecimal;

public class Produtos {
	
	private int Id, barras;
	private String categoria, descri��o;
	public Unidade unidade;
	private BigDecimal custo, margem;
	

}
