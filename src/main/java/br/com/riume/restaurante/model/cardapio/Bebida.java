package br.com.riume.restaurante.model.cardapio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.riume.restaurante.dto.cardapioDTO.BebidaDTO;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("BEBIDA")
public class Bebida extends ItemCardapio {
	private static final long serialVersionUID = 1L;
	
	public Bebida(String nome, Double precos) {
		super(nome, precos);
	}

	public Bebida (BebidaDTO obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.precos = obj.getPrecos();
		this.dataCriacao = obj.getDataCriacao();
		this.deleted = obj.isDeleted();
	}
}
