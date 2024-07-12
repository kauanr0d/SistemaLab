package com.projetolabquimica.projetoLab.model.enums;

public enum StatusAnalise {
	ANDAMENTO, FINALIZADO, CANCELADO;

	@Override
	public String toString() {
		switch (this) {
		case ANDAMENTO:
			return "Em andamento";
		case FINALIZADO:
			return "Finalizado";
		case CANCELADO:
			return "Cancelado";
		default:
			return null;
		}
	}
}
