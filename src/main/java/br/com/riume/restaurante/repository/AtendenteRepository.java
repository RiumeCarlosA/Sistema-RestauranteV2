package br.com.riume.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.riume.restaurante.model.usuarios.Atendente;


public interface AtendenteRepository extends JpaRepository<Atendente, Integer>{

}
