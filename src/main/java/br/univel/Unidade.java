/**
 * Classe que possui as unidades do sistema. como � um sistema de cal�ados, n�o precisamos de muita firula, somente par e unidade.
 */
package br.univel;

public enum Unidade {
	
	PR("PAR"),
	UN("UNIDADE");
	
	private String nome;

	public String getNome() {
		return nome;
	}
	
	private Unidade(String nome){
		this.nome=nome;
	}
	
	
}
