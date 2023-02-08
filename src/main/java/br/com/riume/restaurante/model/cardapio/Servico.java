package br.com.riume.restaurante.model.cardapio;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("SERVICO")
public class Servico extends ItemCardapio {
	
	
	@Column(name = "descricao", length = 500)
	private String descricao;
	
	public Servico(UUID id, String nome, Double precos, String descricao) {
		super(id, nome, precos);
		this.descricao = descricao;
	}

}
