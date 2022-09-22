package br.edu.infnet.apppizzaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.Massa;
import br.edu.infnet.apppizzaria.model.domain.Usuario;
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
	
	public List<Massa> obterLista(Usuario usuario) {
		var produtos = new ArrayList<Massa>();
		
		produtos.addAll(pizzaService.obterLista(usuario));
		produtos.addAll(espagueteService.obterLista(usuario));
		produtos.addAll(esfirraService.obterLista(usuario));
		
		return produtos;
	}

}
