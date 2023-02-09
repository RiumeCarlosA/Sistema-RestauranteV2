package br.com.riume.restaurante.model.usuarios;

import java.util.stream.Collectors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.riume.restaurante.dto.AtendenteDTO;
import br.com.riume.restaurante.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Entity
@DiscriminatorValue("ATENDENTE")
public class Atendente extends Pessoa {
	
	@Builder
	public Atendente (String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
		addPerfil(Perfil.ATENDENTE);
	}
	
	public Atendente (AtendenteDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();;
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		this.deleted = obj.isDeleted();
	}
}
