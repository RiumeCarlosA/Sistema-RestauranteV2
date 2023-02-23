package br.com.riume.restaurante.dto.response;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import br.com.riume.restaurante.model.usuarios.enums.Perfil;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class AtendenteResponseDTO {

	protected UUID id;
	
	@NotNull(message = "O campo nome é obrigatório")
	protected String nome;
	
	@NotNull(message = "O campo Usuário é obrigatório")
	protected String usuario;
	
	@ToString.Exclude
	protected Set<Integer> perfis = new HashSet<>();
	
	@Builder
	public AtendenteResponseDTO (UUID id, String nome, String usuario, Set<Integer> perfis) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.perfis = perfis;
	}
	
	@Builder
	public AtendenteResponseDTO (String nome, String usuario) {
		this.nome = nome;
		this.usuario = usuario;
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
