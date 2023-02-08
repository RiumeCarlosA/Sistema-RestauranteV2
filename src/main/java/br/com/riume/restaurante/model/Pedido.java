package br.com.riume.restaurante.model;

import java.util.UUID;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import br.com.riume.restaurante.model.usuarios.Atendente;
import br.com.riume.restaurante.model.usuarios.Pessoa;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "pedido")
public class Pedido<E extends Atendente> {
	
	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	protected UUID id;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Mesa mesa;
	
	@NotNull
	@ManyToOne
	private Atendente atendente;
	
	@Builder.Default
	@Column(name = "deleted", columnDefinition = "boolean default false")
	protected boolean deleted = false;
}
