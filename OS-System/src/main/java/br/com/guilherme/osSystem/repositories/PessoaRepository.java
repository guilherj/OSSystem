package br.com.guilherme.osSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.guilherme.osSystem.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>  {
	
	@Query("SELECT t FROM Pessoa t WHERE t.cpf = :cpf")
	Pessoa findByCPF(@Param("cpf") String cpf);
}
