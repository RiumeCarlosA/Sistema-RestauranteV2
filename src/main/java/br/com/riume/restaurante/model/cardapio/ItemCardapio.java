package br.com.riume.restaurante.model.cardapio;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Inheritance(strategy=InheritanceType.JOINED)
@DynamicUpdate
@Entity
public abstract class ItemCardapio {
	
	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	protected UUID id;
	
	@NotEmpty
	@NotNull
	@Column(name = "nome", length = 255)
	protected String nome;
	
	@NotEmpty
	@NotNull
	@Column(name = "preco")
	protected Double precos;
}
