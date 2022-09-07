package br.edu.infnet.apppizzaria.model.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.Pizza;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Service
public class PizzaService {

	private static Map<Integer, Pizza> mapaPizza = new HashMap<>();
	private static Integer id = 1;
	
	public void incluir(Pizza pizza) {
		pizza.setId(id++);
		pizza.setData(LocalDateTime.now());
		mapaPizza.put(pizza.getId(), pizza);
		
		AppImpressao.relatorio("Pizza de " + pizza.getSabor(), pizza);
	}
	
	public Collection<Pizza> obterLista() {
		return mapaPizza.values();
	}
	
	public void excluir(Integer id) {
		mapaPizza.remove(id);
	}
	
}
