package br.edu.infnet.apppizzaria.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppizzaria.model.domain.Pizza;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Integer> {

	@Query(value = "FROM Pizza p WHERE p.usuario.id = :usuarioId")
	List<Pizza> findAll(Integer usuarioId);
	
}
