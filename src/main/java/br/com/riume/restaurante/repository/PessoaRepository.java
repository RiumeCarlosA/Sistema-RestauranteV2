package br.com.riume.restaurante.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.riume.restaurante.model.usuarios.Atendente;
import br.com.riume.restaurante.model.usuarios.Pessoa;

public interface PessoaRepository extends JpaRepository<Atendente, Integer>{

	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);

}
