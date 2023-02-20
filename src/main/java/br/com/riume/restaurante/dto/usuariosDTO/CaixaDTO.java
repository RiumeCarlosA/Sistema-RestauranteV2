package br.com.riume.restaurante.dto.usuariosDTO;

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
public class CaixaDTO {
	
	protected UUID id;
	
	@NotNull(message = "O campo nome é obrigatório")
	protected String nome;
	
	@NotNull(message = "O campo Usuário é obrigatório")
	protected String usuario;
	
	@NotNull(message = "O campo senha é obrigatório")
	protected String senha;
	
	@ToString.Exclude
	protected Set<Integer> perfis = new HashSet<>();
	
	@ToString.Exclude
	@Builder.Default
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	protected Instant dataCriacao = Instant.now();
	
	@Builder.Default
	protected boolean deleted = false;
	
	public CaixaDTO () {
		addPerfil(Perfil.ATENDENTE);
	}
	
	@Builder
	public CaixaDTO (String nome, String usuario, String senha) {
		this.nome = nome;
		this.usuario = usuario;
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
