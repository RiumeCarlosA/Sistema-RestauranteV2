package br.com.riume.restaurante.dto;

import java.util.List;
import java.util.UUID;

import br.com.riume.restaurante.model.Pedido;
import br.com.riume.restaurante.model.usuarios.Atendente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MesaDTO {

	protected UUID id;
	
	private int numero;
	
	private Double total;
	
	private List<Pedido<Atendente>> pedido;

	@Builder
	public MesaDTO(int numero) {
		super();
		this.numero = numero;
	}
}
