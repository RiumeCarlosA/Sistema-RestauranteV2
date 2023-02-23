package br.com.riume.restaurante.dto;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.riume.restaurante.model.ItemPedido;
import br.com.riume.restaurante.model.Mesa;
import br.com.riume.restaurante.model.cardapio.ItemCardapio;
import br.com.riume.restaurante.model.usuarios.Atendente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PedidoDTO {

	protected UUID id;
	
	private Mesa mesa;
	
	private Atendente atendente;
	
	private List<ItemPedido<ItemCardapio>> itemPedido;
	
	private Double total;
	
	@Builder.Default
	protected boolean deleted = false;
	
	@Builder.Default
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	private Instant dataCriacao = Instant.now();
	
	public PedidoDTO() {}

	@Builder
	public PedidoDTO(Mesa mesa, Atendente atendente) {
		this.atendente = atendente;
		this.mesa = mesa;
	}
}
