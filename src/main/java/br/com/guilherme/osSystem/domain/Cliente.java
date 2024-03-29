package br.com.guilherme.osSystem.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Cliente extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter 
	@OneToMany(mappedBy = "cliente")
	private List<OS> list = new ArrayList<>();

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}

}
