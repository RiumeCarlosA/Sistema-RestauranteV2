package br.com.riume.restaurante.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.riume.restaurante.dto.ApiErrorDTO;
import br.com.riume.restaurante.dto.usuariosDTO.AtendenteDTO;
import br.com.riume.restaurante.model.usuarios.Atendente;
import br.com.riume.restaurante.service.AtendenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "AtendenteController", description = "EndPoints para Atendente")
@RequestMapping(value = "/atendente")
public class AtendenteController {
	
	@Autowired
	private AtendenteService service;

	
	// @formatter:off
    @Operation(summary = "Endpoint para buscar informacões de todos os Atendentes")
    @ApiResponses({
    	@ApiResponse(responseCode = "200",
    			description = "Identificação dos Atendentes realizadas com sucesso\t\n.",
    			content = @Content( mediaType = MediaType.APPLICATION_JSON_VALUE,
    			schema = @Schema(implementation = AtendenteDTO.class))
    	),
    	@ApiResponse(responseCode = "401", 
				description = " Não autorizado - {error.atendente.find-all.atendente.unauthorized}\t\n",
				content = @Content(schema = @Schema(implementation = ApiErrorDTO.class))
    	),
    	@ApiResponse(responseCode = "404", 
				description = " Nenhum atendente encontrado - {error.atendente.find-all.atendente.not-found}\t\n",
				content = @Content(schema = @Schema(implementation = ApiErrorDTO.class))
    	),
    	@ApiResponse(responseCode = "500", 
				description = " Erro interno - {error.atendente.find-all.atendente.internal-error}\t\n",
				content = @Content(schema = @Schema(implementation = ApiErrorDTO.class))
    	),
    })
    
    // @formatter:on
	@GetMapping("")
	public ResponseEntity<List<AtendenteDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	// @formatter:off
	@Operation(summary = "Endpoint para cadastrar um novo Atendente.")
	@ApiResponses({
		@ApiResponse(responseCode = "201", 
	            description = "Atendente criado com sucesso.", 
	            content = @Content( mediaType = MediaType.APPLICATION_JSON_VALUE,
	                                schema = @Schema(implementation = AtendenteDTO.class))
		),
		@ApiResponse(responseCode = "401", 
				description = " Não autorizado - {error.atendente.create.atendente.unauthorized}\t\n",
				content = @Content(schema = @Schema(implementation = ApiErrorDTO.class))
		),
		@ApiResponse(responseCode = "403", 
				description = " Nome já existe - {error.atendente.create.cliente.name-in-use}\t\n",
				content = @Content(schema = @Schema(implementation = ApiErrorDTO.class))
		),
		@ApiResponse(responseCode = "500", 
				description = " Erro interno - {error.atendente.create.atendente.internal-error}\t\n",
				content = @Content(schema = @Schema(implementation = ApiErrorDTO.class))
		),
	})
	// @formatter:on
	@PostMapping("")
	public ResponseEntity<AtendenteDTO> create(@Valid @RequestBody AtendenteDTO objDTO){
		Atendente newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
