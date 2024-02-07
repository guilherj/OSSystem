package br.com.guilherme.osSystem.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import br.com.guilherme.osSystem.domain.Tecnico;
import br.com.guilherme.osSystem.util.OsSystemConstans;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TecnicoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = OsSystemConstans.CAMPO_NOME_OBRIGATORIO)
	private String nome;
	
	@CPF
	@NotEmpty(message = OsSystemConstans.CAMPO_CPF_OBRIGATORIO)
	private String cpf;
	
	@NotEmpty(message = OsSystemConstans.CAMPO_TELEFONE_OBRIGATORIO)
	private String telefone;	
	
	public TecnicoDTO(Tecnico obj) {
		
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
		
	}

}
