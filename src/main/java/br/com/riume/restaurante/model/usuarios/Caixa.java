package br.com.riume.restaurante.model.usuarios;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Builder;

@Entity
@DiscriminatorValue("CAIXA")
public class Caixa extends Pessoa{

	@Builder
	public Caixa(String nome, String senha) {
		super(nome, senha);
	}
	
	
}
