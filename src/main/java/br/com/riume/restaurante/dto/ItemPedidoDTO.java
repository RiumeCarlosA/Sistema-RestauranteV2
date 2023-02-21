package br.com.riume.restaurante.dto;

import java.util.UUID;

import br.com.riume.restaurante.model.Pedido;
import br.com.riume.restaurante.model.cardapio.ItemCardapio;
import br.com.riume.restaurante.model.usuarios.Atendente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ItemPedidoDTO {

	private UUID id;
	
	private Pedido<Atendente> pedido;
	
	private ItemCardapio produto;
	
	private int quantidade;
	
	private Double total;
	
	@Builder
	public ItemPedidoDTO(Pedido<Atendente> pedido, ItemCardapio produto, int quantidade) {
		super();
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}
}
