package br.com.riume.restaurante.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
