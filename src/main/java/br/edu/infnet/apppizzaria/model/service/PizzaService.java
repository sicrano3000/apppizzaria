package br.edu.infnet.apppizzaria.model.service;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.Pizza;
import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.repository.PizzaRepository;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	public void incluir(Pizza pizza) {
		pizza.setData(LocalDateTime.now());
		
		pizzaRepository.save(pizza);
		
		AppImpressao.relatorio("Pizza de " + pizza.getSabor(), pizza);
	}
	
	public Collection<Pizza> obterLista() {
		return (Collection<Pizza>) pizzaRepository.findAll();
	}
	
	public Collection<Pizza> obterLista(Usuario usuario) {
		return (Collection<Pizza>) pizzaRepository.findAll(usuario.getId());
	}
	
	public void excluir(Integer id) {
		pizzaRepository.deleteById(id);
	}
	
}
