package br.univel.classes;

/**
 * Classe que possui as siglas dos estados e os estados pr�priamente ditos
 */
public enum Estado {

	AC("Acre"), AL("Alagoas"), AP("Amap�"), AM("Amazonas"), BA("Bahia"), CE("Cear�"), DF("Distrito Federal"), ES(
			"Espirito Santo"), GO("Goi�s"), MA("Maranh�o"), MT("Mato Grosso"), MS("Mato Grosso do Sul"), MG(
					"Minas Gerais"), PA("Par�"), PB("Para�ba"), PR("Paran�"), PE("Pernambuco"), PI("Piau�"), RJ(
							"Rio de Janeiro"), RN("Rio Grande do Norte"), RS("Rio Grande do Sul"), RO("Rond�nia"), RR(
									"Roraima"), SC("Santa Catarina"), SP("S�o Paulo"), SE("Sergipe"), TO("Tocantins");

	private String nome;

	public String getNome() {
		return nome;
	}

	private Estado(String nome) {
		this.nome = nome;
	}

	public static String transformar(String estado) {
		for (Estado e : Estado.values()) {
			if (e.getNome().equals(estado)) {
				return e.name();
			}
		}
		return "";
	}

}