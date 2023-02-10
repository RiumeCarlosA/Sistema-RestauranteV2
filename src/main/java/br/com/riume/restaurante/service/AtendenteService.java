package br.com.riume.restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.riume.restaurante.dto.AtendenteDTO;
import br.com.riume.restaurante.model.usuarios.Atendente;
import br.com.riume.restaurante.repository.AtendenteRepository;
import br.com.riume.restaurante.repository.PessoaRepository;

@Service
public class AtendenteService {

	@Autowired
	private AtendenteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public AtendenteDTO convertAtendenteToAtendenteDTO(Atendente atendente) {
		return AtendenteDTO.builder()
						.id(atendente.getId())
						.nome(atendente.getNome())
						.senha(atendente.getSenha())
						.perfis(atendente.getPerfil())
						.dataCriacao(atendente.getDataCriacao())
						.deleted(atendente.isDeleted())
						.build();
	}
	
	public Atendente create(AtendenteDTO objDTO) {
		objDTO.setId(null);
		Atendente newObj = new Atendente(objDTO);
		return repository.save(newObj);
	}
}
