package com.viniciosrodrigues.cursomc.domain.enums;

public enum EstadoPagamento {
	PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");

	private Integer id;

	private String descricao;

	private EstadoPagamento(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoPagamento toEnum(Integer id) {
		if (id == null)
			return null;
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (x.id.equals(id))
				return x;

		}
		throw new IllegalArgumentException("Id inválido: " + id);
	}
}
