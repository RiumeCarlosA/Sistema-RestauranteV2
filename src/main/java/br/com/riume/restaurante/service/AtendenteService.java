package br.com.riume.restaurante.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.riume.restaurante.dto.response.AtendenteResponseDTO;
import br.com.riume.restaurante.dto.usuariosDTO.AtendenteDTO;
import br.com.riume.restaurante.model.usuarios.Atendente;
import br.com.riume.restaurante.repository.usuarios.AtendenteRepository;

@Service
public class AtendenteService {

	@Autowired
	private AtendenteRepository repository;
	
//	@Autowired
//	private PessoaRepository pessoaRepository;
	
	
	public AtendenteDTO convertAtendenteToAtendenteDTO(Atendente atendente) {
		return AtendenteDTO.builder()
						.id(atendente.getId())
						.nome(atendente.getNome())
						.usuario(atendente.getUsuario())
						.senha(atendente.getSenha())
						.perfis(atendente.getPerfil())
						.dataCriacao(atendente.getDataCriacao())
						.deleted(atendente.isDeleted())
						.build();
	}
	
	public AtendenteResponseDTO convertAtendenteToAtendenteResponseDTO(Atendente atendente) {
		return AtendenteResponseDTO.builder()
						.id(atendente.getId())
						.nome(atendente.getNome())
						.usuario(atendente.getUsuario())
						.perfis(atendente.getPerfil())
						.build();
	}
	
	public Atendente create(AtendenteDTO objDTO) {
		objDTO.setId(null);
		Atendente newObj = new Atendente(objDTO);
		return repository.save(newObj);
	}
	
	public List<AtendenteResponseDTO> findAll() {
		List<Atendente> list = repository.findAll();
		
		List<AtendenteResponseDTO> listDTO = list.stream()
													.map(obj -> (obj.isDeleted()) ? null : convertAtendenteToAtendenteResponseDTO(obj))
													.collect(Collectors.toList());
		
		listDTO.remove(null);
		
		return listDTO;
		}

	public List<AtendenteDTO> findAllFull() {
		List<Atendente> list = repository.findAll();
		
		List<AtendenteDTO> listDTO = list.stream()
													.map(obj -> (obj.isDeleted()) ? null : convertAtendenteToAtendenteDTO(obj))
													.collect(Collectors.toList());
		
		listDTO.remove(null);
		
		return listDTO;
		}
	}

