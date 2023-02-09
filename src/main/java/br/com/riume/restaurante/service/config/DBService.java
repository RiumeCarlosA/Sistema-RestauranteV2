package br.com.riume.restaurante.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.riume.restaurante.model.ItemPedido;
import br.com.riume.restaurante.model.Mesa;
import br.com.riume.restaurante.model.Pedido;
import br.com.riume.restaurante.model.cardapio.Bebida;
import br.com.riume.restaurante.model.cardapio.ItemCardapio;
import br.com.riume.restaurante.model.usuarios.Atendente;
import br.com.riume.restaurante.repository.ItemCardapioRepository;
import br.com.riume.restaurante.repository.ItemPedidoRepository;
import br.com.riume.restaurante.repository.MesaRepository;
import br.com.riume.restaurante.repository.PedidoRepository;
import br.com.riume.restaurante.repository.PessoaRepository;

@Service
public class DBService {
		
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemCardapioRepository itemCardapioRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private MesaRepository mesaRepository;
	
	public void instanciaDB() {
		Atendente ate1 = new Atendente("Riume Carlos", "123@mudar");
		Mesa mesa = new Mesa(1);
		Pedido<Atendente> pedido = new Pedido<>(mesa, ate1);
		Bebida coca = new Bebida(null, "Coca-cola", 5.55);
		ItemPedido<ItemCardapio> itemPedido = new ItemPedido<>(pedido, coca, 2);
		
		itemCardapioRepository.save(coca);
		mesaRepository.save(mesa);
		pessoaRepository.save(ate1);
		pedidoRepository.save(pedido);
		itemPedidoRepository.save(itemPedido);
		
	}
}
