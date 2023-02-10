package br.com.riume.restaurante.model.usuarios;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Builder;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Builder
	public Admin(String nome, String senha) {
		super(nome, senha);
	}
	
}
