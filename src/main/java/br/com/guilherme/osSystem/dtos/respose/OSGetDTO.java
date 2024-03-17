package br.com.guilherme.osSystem.dtos.respose;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.guilherme.osSystem.domain.Cliente;
import br.com.guilherme.osSystem.domain.OS;
import br.com.guilherme.osSystem.domain.Tecnico;
import br.com.guilherme.osSystem.domain.enums.Prioridade;
import br.com.guilherme.osSystem.domain.enums.Status;
import br.com.guilherme.osSystem.dtos.ClienteDTO;
import br.com.guilherme.osSystem.dtos.TecnicoDTO;
import br.com.guilherme.osSystem.util.OsSystemConstans;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OSGetDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;
	
	@Getter
	@Setter
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	
	@Getter
	@Setter
	@NotEmpty(message = OsSystemConstans.CAMPO_OBSERVACOES_OBRIGATORIO)
	private String observacoes;
	
	@Setter
	private Integer prioridade;
	
	@Setter
	private Integer status;	
	
	@Getter
	@Setter
	private TecnicoDTO tecnico;
	
	@Getter
	@Setter
	private ClienteDTO cliente;

	public OSGetDTO(OS obj) {
		super();
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.observacoes = obj.getObservacoes();
		this.prioridade = obj.getPrioridade().getCod();
		this.status = obj.getStatus().getCod();
		this.tecnico = new TecnicoDTO(obj.getTecnico());
		this.cliente = new ClienteDTO(obj.getCliente());
	}
	
	public Prioridade getPrioridade() {
		return Prioridade.toEnum(this.prioridade);
	}
	
	public Status getStatus() {
		return Status.toEnum(this.status);
	}

}
