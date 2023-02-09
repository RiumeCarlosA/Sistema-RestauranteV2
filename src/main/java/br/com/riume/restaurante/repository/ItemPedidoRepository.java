package br.com.riume.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.riume.restaurante.model.ItemPedido;
import br.com.riume.restaurante.model.cardapio.ItemCardapio;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido<ItemCardapio>, Integer> {

}
