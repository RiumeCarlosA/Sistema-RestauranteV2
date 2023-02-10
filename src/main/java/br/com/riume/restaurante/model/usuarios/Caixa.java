package br.com.riume.restaurante.model.usuarios;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Builder;

@Entity
@DiscriminatorValue("CAIXA")
public class Caixa extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Builder
	public Caixa(String nome, String senha) {
		super(nome, senha);
	}
	
	
}
