package br.com.riume.restaurante.model.usuarios;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ATENDENTE")
public class Atendente extends Pessoa {

}
