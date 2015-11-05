/**
 * Classe que possui as siglas dos estados e os estados própriamente ditos
 */

package br.univel.classes;

public enum Estado {

	AC("Acre"), AL("Alagoas"), AP("Amapá"), AM("Amazonas"), BA("Bahia"), CE(
			"Ceará"), DF("Distrito Federal"), ES("Espirito Santo"), GO("Goiás"), MA(
			"Maranhão"), MT("Mato Grosso"), MS("Mato Grosso do Sul"), MG(
			"Minas Gerais"), PA("Pará"), PB("Paraíba"), PR("Paraná"), PE(
			"Pernambuco"), PI("Piauí"), RJ("Rio de Janeiro"), RN(
			"Rio Grande do Norte"), RS("Rio Grande do Sul"), RO("Rondônia"), RR(
			"Roraima"), SC("Santa Catarina"), SP("São Paulo"), SE("Sergipe"), TO(
			"Tocantins");

	private String nome;

	public String getNome() {
		return nome;
	}

	private Estado(String nome) {
		this.nome = nome;
	}
}