package br.com.guilherme.osSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.guilherme.osSystem.domain.OS;

@Repository
public interface OSRepository extends JpaRepository<OS, Integer>{

}
