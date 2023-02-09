package br.com.riume.restaurante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.riume.restaurante.dto.AtendenteDTO;
import br.com.riume.restaurante.model.usuarios.Atendente;
import br.com.riume.restaurante.model.usuarios.Pessoa;
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
						.email(atendente.getEmail())
						.senha(atendente.getSenha())
						.perfis(atendente.getPerfil())
						.cpf(atendente.getCpf())
						.dataCriacao(atendente.getDataCriacao())
						.deleted(atendente.isDeleted())
						.build();
	}
	
	private void validaPorCpfEEmail(AtendenteDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
			throw new DataIntegrityViolationException("CPF Inválido");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
			throw new DataIntegrityViolationException("E-mail Inválido");
		}
	}
	
	public Atendente create(AtendenteDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Atendente newObj = new Atendente(objDTO);
		return repository.save(newObj);
	}
}
