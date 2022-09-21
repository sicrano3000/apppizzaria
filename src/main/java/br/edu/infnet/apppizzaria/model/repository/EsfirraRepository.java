package br.edu.infnet.apppizzaria.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppizzaria.model.domain.Esfirra;

@Repository
public interface EsfirraRepository extends CrudRepository<Esfirra, Integer> {
	
}
