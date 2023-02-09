package br.com.riume.restaurante.model.usuarios;

import java.util.stream.Collectors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.riume.restaurante.dto.AtendenteDTO;
import br.com.riume.restaurante.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@Entity
@DiscriminatorValue("ATENDENTE")
public class Atendente extends Pessoa {
	
	@Builder
	public Atendente (String nome, String senha) {
		super(nome, senha);
		addPerfil(Perfil.ATENDENTE);
	}
	
	public Atendente (AtendenteDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		this.deleted = obj.isDeleted();
	}
}
