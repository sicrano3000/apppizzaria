package br.edu.infnet.apppizzaria.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppizzaria.model.domain.Pizza;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Integer> {
	
}
