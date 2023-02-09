package br.com.riume.restaurante.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.riume.restaurante.dto.AtendenteDTO;
import br.com.riume.restaurante.model.usuarios.Atendente;
import br.com.riume.restaurante.service.AtendenteService;

@RestController
@RequestMapping(value = "/atendente")
public class AtendenteController {
	
	@Autowired
	private AtendenteService service;
	
	@PostMapping("")
	public ResponseEntity<AtendenteDTO> create(@Valid @RequestBody AtendenteDTO objDTO){
		Atendente newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
