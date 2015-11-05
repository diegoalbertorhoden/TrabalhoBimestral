/**
 * Classe que possui as unidades do sistema. como é um sistema de calçados, não precisamos de muita firula, somente par e unidade.
 */
package br.univel.classes;

public enum Unidade {

	PR("PAR"), UN("UNIDADE");

	private String nome;

	public String getNome() {
		return nome;
	}

	private Unidade(String nome) {
		this.nome = nome;
	}

}
