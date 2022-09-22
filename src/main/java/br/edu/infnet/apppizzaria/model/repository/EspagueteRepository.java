package br.edu.infnet.apppizzaria.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppizzaria.model.domain.Espaguete;

@Repository
public interface EspagueteRepository extends CrudRepository<Espaguete, Integer> {
	
	@Query(value = "FROM Espaguete e WHERE e.usuario.id = :usuarioId")
	List<Espaguete> findAll(Integer usuarioId);
	
}
