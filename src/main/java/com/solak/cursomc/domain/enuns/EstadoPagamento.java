package com.solak.cursomc.domain.enuns;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;
	
	//construtor de tipo enum é private
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
		
	}
	
	// enum instanciado so tem get, nao será alterado nome
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	//operacao que recebe um cod e retorna um obj do tipo cliente instanciado de acordo com id que for passado
	//static pq operação  pode ser executada msm sem instanciar obj 
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod ==null) {
			return null;
		}
		//percorre F e J
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " +cod);
	}

}
