package br.com.riume.restaurante.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.riume.restaurante.model.usuarios.Atendente;
import br.com.riume.restaurante.repository.PessoaRepository;

@Service
public class DBService {
		
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void instanciaDB() {
		Atendente tec1 = new Atendente("Riume Carlos", "140.946.719-86", "riumecarlos@gmail.com", "123@mudar");
		pessoaRepository.save(tec1);
	}
}
