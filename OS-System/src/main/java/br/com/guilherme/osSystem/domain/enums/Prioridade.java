package br.com.guilherme.osSystem.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Prioridade {

	BAIXA(0, "BAIXA"), 
	MEDIA(1, "MEDIA"), 
	ALTA(2, "ALTA");

	private Integer cod;
	private String descricao;

	
	public static Prioridade toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(Prioridade x : Prioridade.values()) {
			if(cod.equals(x.getCod()) ) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Prioridade inválida!" + cod);
	}
}
