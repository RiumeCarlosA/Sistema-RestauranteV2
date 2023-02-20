package br.com.riume.restaurante.model.cardapio;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.riume.restaurante.dto.cardapioDTO.ServicoDTO;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("SERVICO")
public class Servico extends ItemCardapio {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "descricao", length = 500)
	private String descricao;
	
	public Servico(String nome, Double precos, String descricao) {
		super(nome, precos);
		this.descricao = descricao;
	}

	public Servico(ServicoDTO obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.precos = obj.getPrecos();
		this.dataCriacao = obj.getDataCriacao();
		this.deleted = obj.isDeleted();
		this.descricao = obj.getDescricao();
	}

}
