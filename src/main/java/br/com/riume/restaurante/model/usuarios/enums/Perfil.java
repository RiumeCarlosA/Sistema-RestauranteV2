package br.com.riume.restaurante.model.usuarios.enums;

import lombok.Getter;

@Getter
public enum Perfil {
	
	ADMIN(0, "ROLE_ADMIN"), CAIXA(1, "ROLE_CAIXA"), ATENDENTE(2, "ROLE_ATENDENTE");
	
	private Integer codigo;
	
	private String descricao;
	
	private Perfil(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getCodigo())){
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido");
	}
}
