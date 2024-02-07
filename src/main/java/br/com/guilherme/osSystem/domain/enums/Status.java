package br.com.guilherme.osSystem.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
	
	ABERTO(0, "ABERTO"), 
	ANDAMENTO(1, "ANDAMENTO"), 
	ENCERRADO(2, "ENCERRADO");

	private Integer cod;
	private String descricao;

	
	public static Status toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(Status x : Status.values()) {
			if(cod.equals(x.getCod()) ) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Status inválido!" + cod);
	}

}
