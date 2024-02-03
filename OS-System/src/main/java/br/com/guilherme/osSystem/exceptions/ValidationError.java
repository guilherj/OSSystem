package br.com.guilherme.osSystem.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;


public class ValidationError extends StandartError {
	private static final long serialVersionUID = 1L;

	@Getter	
	private List<FieldMessage> errors = new ArrayList<>();
	
	
	public ValidationError(LocalDateTime timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}
	
	public ValidationError() {
		super();
	}
	
	
	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}





}
