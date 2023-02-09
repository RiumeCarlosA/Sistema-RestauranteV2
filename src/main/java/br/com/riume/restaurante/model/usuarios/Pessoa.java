package br.com.riume.restaurante.model.usuarios;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedDate;

import br.com.riume.restaurante.enums.Perfil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Table(name = "pessoa",
		uniqueConstraints = @UniqueConstraint(name = "UNQ_PESSOA", columnNames = {"cpf", "email"}),
		indexes = {@Index(name = "IDX_PESSOA_CPF", columnList = "cpf"), @Index(name = "IDX_PESSOA_EMAIL", columnList = "email")}
)
@Inheritance(strategy=InheritanceType.JOINED)
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
	
	@CPF
	@NotNull
	@NaturalId
	@Column(name = "cpf", unique = true, nullable = false)
	protected String cpf;
	
	@Email
	@NotNull
	@NaturalId
	@Column(name = "email", unique = true, nullable = false)
	protected String email;
	
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
	public Pessoa (String nome, String cpf, String email, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
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

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;

		Pessoa  other = (Pessoa ) obj;

		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.getCpf()))
			return false;

		return true;
	}
	
}