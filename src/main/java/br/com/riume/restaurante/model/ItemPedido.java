package br.com.riume.restaurante.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import br.com.riume.restaurante.model.cardapio.ItemCardapio;
import br.com.riume.restaurante.model.usuarios.Atendente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DynamicUpdate
@Entity
@Table(name = "item_pedido")
public class ItemPedido<E extends ItemCardapio> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	protected UUID id;
	
	@ManyToOne
	private Pedido<Atendente> pedido;
	
	@OneToOne
	private ItemCardapio produto;
	
	@Column(name = "quantidade", nullable = false)
	private int quantidade;
	
	@Column(name = "total")
	private Double total;
	
	public ItemPedido(Pedido<Atendente> pedido, ItemCardapio produto, int quantidade) {
		super();
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}
		
	public Double getTotal() {
		this.total = this.produto.getPrecos() * this.quantidade;
		return this.total;
	}
}
