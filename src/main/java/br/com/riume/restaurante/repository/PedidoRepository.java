package br.com.riume.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.riume.restaurante.model.Pedido;
import br.com.riume.restaurante.model.usuarios.Atendente;

public interface PedidoRepository extends JpaRepository<Pedido<Atendente>, Integer>{

}
