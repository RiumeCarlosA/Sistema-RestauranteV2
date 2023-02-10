package br.com.riume.restaurante.model.cardapio;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("PRATO")
public class Prato extends ItemCardapio implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "descricao", length = 500)
	private String descricao;
	
	public Prato(UUID id, String nome, Double precos, String descricao) {
		super(id, nome, precos);
		this.descricao = descricao;
	}
}
