package br.com.inmetrics.treinamento.enumerator;

public enum EnumTipoCEP {
	
	LOCALIDADE("LOG"),
	PROMOCIONAL("PRO"),
	CAIXA_POSTAL("CPC"),
	GRANDE_USUARIO("GRU"),
	UNIDADE_OPERACIONAL("OUP"),
	TODOS("ALL");

	private final String value;
	
	EnumTipoCEP(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
