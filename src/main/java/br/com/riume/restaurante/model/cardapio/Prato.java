package br.com.riume.restaurante.model.cardapio;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.riume.restaurante.dto.cardapioDTO.PratoDTO;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("PRATO")
public class Prato extends ItemCardapio {
	private static final long serialVersionUID = 1L;

	@Column(name = "descricao", length = 500)
	private String descricao;
	
	public Prato(String nome, Double precos, String descricao) {
		super(nome, precos);
		this.descricao = descricao;
	}

	public Prato (PratoDTO obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.precos = obj.getPrecos();
		this.dataCriacao = obj.getDataCriacao();
		this.deleted = obj.isDeleted();
		this.descricao = obj.getDescricao();
	}
}
