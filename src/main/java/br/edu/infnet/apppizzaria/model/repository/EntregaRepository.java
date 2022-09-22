package br.edu.infnet.apppizzaria.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppizzaria.model.domain.Entrega;

@Repository
public interface EntregaRepository extends CrudRepository<Entrega, Integer> {

	@Query(value = "FROM Entrega e WHERE e.usuario.id = :usuarioId")
	List<Entrega> findAll(Integer usuarioId);
	
}
