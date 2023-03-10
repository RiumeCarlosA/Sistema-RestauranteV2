package br.com.riume.restaurante.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.riume.restaurante.model.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, UUID> {

}
