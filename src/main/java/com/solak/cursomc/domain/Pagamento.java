package com.solak.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.solak.cursomc.domain.enuns.EstadoPagamento;

//abstract -> para garantir que não será instanciado pagamento, e sim pagtoComCartao e PagtoComBoleto

@Entity
@Inheritance(strategy=InheritanceType.JOINED)  //estrategia para dizer como mapeará tabela no banco de dados, se usado single table cria o tabelao unico
public abstract class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id  //vai ser mesmo do correspondente do pedido, por isso nao vai strategy
	private Integer id;
	
	//retirado EstadoPagamento e informado Integer
	private Integer estado;
    
	@JsonBackReference
	@OneToOne
	@JoinColumn(name="pedido_id")
	@MapsId
	private Pedido pedido;

	public Pagamento() {

	}

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// retirado estadono return e informado:
	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	//add .getCod()
	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	// nao precisa de Hash COde e Equals em pagto com boleto e cartao pois elas
	// herdarão daqui:
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
