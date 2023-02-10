package br.com.riume.restaurante.dto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.riume.restaurante.model.usuarios.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
public class AtendenteDTO {
	
	protected UUID id;
	
	@NotNull(message = "O campo nome é obrigatório")
	protected String nome;
	
	@NotNull(message = "O campo CPF é obrigatório")
	protected String cpf;
	
	@NotNull(message = "O campo E-mail é obrigatório")
	protected String email;
	
	@NotNull(message = "O campo senha é obrigatório")
	protected String senha;
	
	@ToString.Exclude
	protected Set<Integer> perfis = new HashSet<>();
	
	@ToString.Exclude
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	protected Instant dataCriacao = Instant.now();
	
	protected boolean deleted = false;
	
	public AtendenteDTO () {
		super();
		addPerfil(Perfil.ATENDENTE);
	}
	
	@Builder
	public AtendenteDTO (String nome, String cpf, String email, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		addPerfil(Perfil.ATENDENTE);
	}
	
	public Set<Perfil> getPerfis() {
		return this.perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public Set<Integer> getPerfil() {
		return this.perfis;
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}
	
}
