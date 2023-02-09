package br.com.riume.restaurante.model.usuarios;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import br.com.riume.restaurante.enums.Perfil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@DynamicUpdate
@Entity
public abstract class Pessoa {
	
	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	protected UUID id;
	
	@NotEmpty
	@Column(name = "nome", length = 255)
	protected String nome;
	
	@NotNull
	@NotEmpty
	@Column(name = "senha", nullable = false)
	protected String senha;
	
	@ToString.Exclude
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	protected Set<Integer> perfis = new HashSet<>();
	
	@ToString.Exclude
	@CreatedDate
	protected LocalDate dataCriacao = LocalDate.now();
	
	@Column(name = "deleted", columnDefinition = "boolean default false")
	protected boolean deleted = false;

	
	public Pessoa () {
		super();
		addPerfil(Perfil.ATENDENTE);
	}
	
	//@Builder
	public Pessoa (String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
		addPerfil(Perfil.ATENDENTE);
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public Set<Integer> getPerfil() {
		return this.perfis;
	}
	
	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}
	
	
}