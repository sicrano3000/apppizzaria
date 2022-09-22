package br.edu.infnet.apppizzaria.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppizzaria.model.domain.Massa;

@Repository
public interface MassaRepository extends CrudRepository<Massa, Integer> {

	@Query(value = "FROM Massa m WHERE m.usuario.id = :usuarioId")
	List<Massa> findAll(Integer usuarioId);
	
}
