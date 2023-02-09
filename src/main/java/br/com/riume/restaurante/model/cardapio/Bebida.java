package br.com.riume.restaurante.model.cardapio;

import java.util.UUID;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("BEBIDA")
public class Bebida extends ItemCardapio {
	
	public Bebida(UUID id, String nome, Double precos) {
		super(id, nome, precos);
	}

}
