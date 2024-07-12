package com.projetolabquimica.projetoLab.model.enums;

public enum StatusEquipamento {
	ATIVO, MANUTENCAO, DESCARTE;

	public String toString() {
		switch (this) {
		case ATIVO:
			return "Ativo";
		case MANUTENCAO:
			return "Manutenção";
		case DESCARTE:
			return "Descarte";
		default:
			throw new IllegalArgumentException("Status de Equipamento não reconhecido.");
		}
	}
}
