package br.edu.infnet.apppizzaria.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppizzaria.model.domain.Esfirra;

@Repository
public interface EsfirraRepository extends CrudRepository<Esfirra, Integer> {
	
	@Query(value = "FROM Esfirra e WHERE e.usuario.id = :usuarioId")
	List<Esfirra> findAll(Integer usuarioId);
	
}
