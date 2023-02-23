package br.com.riume.restaurante.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.riume.restaurante.model.cardapio.ItemCardapio;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, UUID> {

}
