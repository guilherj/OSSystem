package br.com.guilherme.osSystem.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFoundException (ObjectNotFoundException ex) {
		
		StandartError error = new StandartError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage());		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegratyViolationException.class)
	public ResponseEntity<StandartError> dataIntegratyViolationException (DataIntegratyViolationException ex) {
		
		StandartError error = new StandartError(LocalDateTime.now(), HttpStatus.BAD_REQUEST .value(), ex.getMessage());		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
