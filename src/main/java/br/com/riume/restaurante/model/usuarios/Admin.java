package br.com.riume.restaurante.model.usuarios;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Builder;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Pessoa{

	@Builder
	public Admin(String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
	}
	
}
