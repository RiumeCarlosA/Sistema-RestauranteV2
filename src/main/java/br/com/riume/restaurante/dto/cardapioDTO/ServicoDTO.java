package br.com.riume.restaurante.dto.cardapioDTO;

import java.time.Instant;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
public class ServicoDTO {

	protected UUID id;
	
	@NotNull(message = "O campo nome é obrigatório")
	protected String nome;
	
	@NotNull(message = "O campo preço é obrigatório")
	protected Double precos;
	
	@NotNull(message = "O campo descrição é obrigatório")
	protected String descricao;
	
	@ToString.Exclude
	@Builder.Default
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	protected Instant dataCriacao = Instant.now();
	
	@Builder.Default
	protected boolean deleted = false;
	
	ServicoDTO(String nome, Double precos, String descricao) {
		this.nome = nome;
		this.precos = precos;
		this.descricao = descricao;
	}	
}
