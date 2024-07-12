package com.projetolabquimica.projetoLab.model.enums;

public enum StatusResiduos {
	TRATADO, NAO_TRATADO, DESCARTADO;

	@Override
	public String toString() {
		switch (this) {
		case TRATADO:
			return "Tratado";
		case NAO_TRATADO:
			return "Não tratado";
		case DESCARTADO:
			return "Descartado";
		default:
			throw new IllegalArgumentException("Status de resíduos não reconhecido.");
		}
	}
}
