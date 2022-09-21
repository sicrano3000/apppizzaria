package br.edu.infnet.apppizzaria.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppizzaria.model.domain.Espaguete;

@Repository
public interface EspagueteRepository extends CrudRepository<Espaguete, Integer> {
	
}
