package br.com.riume.restaurante.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "mesa")
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	protected UUID id;
	
	@Column(name = "numero_mesa", nullable = false)
	private int numero;
	
	@Column(name = "total")
	private Double total;
	
	@OneToMany(mappedBy = "mesa")
	private List<Pedido<Atendente>> pedido;
	
	public Mesa(int numero) {
		super();
		this.numero = numero;
	}
	
	public void atualizarTotal() {
		for(Pedido<Atendente> i : this.pedido) {
			i.atualizarTotal();
			this.total += i.getTotal();
		}		
	}

}
