package br.com.guilherme.osSystem.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandartError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private LocalDateTime timestamp;
	private Integer status;
	private String error;

}
