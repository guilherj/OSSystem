package br.com.guilherme.osSystem.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.guilherme.osSystem.domain.OS;
import br.com.guilherme.osSystem.domain.enums.Prioridade;
import br.com.guilherme.osSystem.domain.enums.Status;
import br.com.guilherme.osSystem.util.OsSystemConstans;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OSDTO implements Serializable {
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
	private Integer tecnico;
	
	@Getter
	@Setter
	private Integer cliente;

	public OSDTO(OS obj) {
		super();
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.observacoes = obj.getObservacoes();
		this.prioridade = obj.getPrioridade().getCod();
		this.status = obj.getStatus().getCod();
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
	}
	
	public Prioridade getPrioridade() {
		return Prioridade.toEnum(this.prioridade);
	}
	
	public Status getStatus() {
		return Status.toEnum(this.status);
	}

}
