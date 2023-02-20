package br.com.riume.restaurante.model.usuarios;

import java.util.stream.Collectors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.riume.restaurante.dto.usuariosDTO.CaixaDTO;
import br.com.riume.restaurante.model.usuarios.enums.Perfil;
import lombok.Builder;

@Entity
@DiscriminatorValue("CAIXA")
public class Caixa extends Pessoa {
	private static final long serialVersionUID = 1L;

	@Builder
	public Caixa(String nome, String usuario, String senha) {
		super(nome, usuario, senha);
		addPerfil(Perfil.CAIXA);
	}
	
	public Caixa (CaixaDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		this.deleted = obj.isDeleted();
	}
	
}
