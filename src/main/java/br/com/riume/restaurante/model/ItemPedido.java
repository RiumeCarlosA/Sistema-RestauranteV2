package br.com.riume.restaurante.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import br.com.riume.restaurante.model.cardapio.ItemCardapio;
import br.com.riume.restaurante.model.usuarios.Atendente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@DynamicUpdate
@Entity
@Table(name = "item_pedido")
public class ItemPedido<E extends ItemCardapio> {
	
	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	protected UUID id;
	
	@ManyToOne
	private Pedido<Atendente> pedido;
	
	@ManyToOne
	private ItemCardapio produto;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false)
	private Double total;
}
