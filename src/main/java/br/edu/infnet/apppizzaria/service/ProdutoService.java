package br.edu.infnet.apppizzaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.service.EsfirraService;
import br.edu.infnet.apppizzaria.model.service.EspagueteService;
import br.edu.infnet.apppizzaria.model.service.PizzaService;

@Service
public class ProdutoService {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private EspagueteService espagueteService;
	
	@Autowired
	private EsfirraService esfirraService;
	
	public List<Object> obterLista() {
		var produtos = new ArrayList<Object>();
		
		produtos.addAll(pizzaService.obterLista());
		produtos.addAll(espagueteService.obterLista());
		produtos.addAll(esfirraService.obterLista());
		
		return produtos;
	}

}
