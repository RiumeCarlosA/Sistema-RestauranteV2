package br.com.riume.restaurante.repository.usuarios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.riume.restaurante.model.usuarios.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

}
