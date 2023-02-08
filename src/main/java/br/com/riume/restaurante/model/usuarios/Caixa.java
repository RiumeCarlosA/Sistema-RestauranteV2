package br.com.riume.restaurante.model.usuarios;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CAIXA")
public class Caixa extends Atendente{

}
