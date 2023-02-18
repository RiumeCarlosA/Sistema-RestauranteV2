package br.com.riume.restaurante.model.cardapio;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DynamicUpdate
@Entity
public abstract class ItemCardapio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	protected UUID id;
	
	@Column(name = "nome", length = 255)
	protected String nome;
	
	@Column(name = "preco")
	protected Double precos;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	protected Instant dataCriacao = Instant.now();
	
	@Column(name = "deleted")
	protected boolean deleted = false;
	
	ItemCardapio() {
	}
	
	ItemCardapio(String nome, Double precos) {
		this.nome = nome;
		this.precos = precos;
	}
}
