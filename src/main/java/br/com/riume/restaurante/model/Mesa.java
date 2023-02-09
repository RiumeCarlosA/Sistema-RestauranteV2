package br.com.riume.restaurante.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

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
public class Mesa {
	
	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	protected UUID id;
	
	@Column(name = "numero_mesa", nullable = false)
	private int numero;
	
//	@NotNull
//	@OneToMany(mappedBy = "mesa")
//	private Mesa mesa;

}
