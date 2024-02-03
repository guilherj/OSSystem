package br.com.guilherme.osSystem.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String fieldName;
	
	@Getter
	@Setter
	private String message;

}
