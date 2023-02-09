package br.com.riume.restaurante.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import br.com.riume.restaurante.model.cardapio.ItemCardapio;
import br.com.riume.restaurante.model.usuarios.Atendente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@ToString
@DynamicUpdate
@Entity
@Table(name = "pedido")
public class Pedido<E extends Atendente> {
	
	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	protected UUID id;
	
	@ManyToOne
	private Mesa mesa;
	
	@ManyToOne
	private Atendente atendente;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido<ItemCardapio>> itemPedido;
	
	@Column(name = "total_pedido")
	private Double total;
	
	@Builder.Default
	@Column(name = "deleted", columnDefinition = "boolean default false")
	protected boolean deleted = false;
	
	public Pedido(Mesa mesa, Atendente atendente) {
		this.atendente = atendente;
		this.mesa = mesa;
	}
	
	public void atualizarTotal() {
		for(ItemPedido<ItemCardapio> i : this.itemPedido) {
			this.total += i.getTotal();
		}		
	}
	
}
