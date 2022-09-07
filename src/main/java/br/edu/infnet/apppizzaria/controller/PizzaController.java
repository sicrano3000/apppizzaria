package br.edu.infnet.apppizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppizzaria.model.domain.Pizza;
import br.edu.infnet.apppizzaria.model.service.PizzaService;

@Controller
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;

	@GetMapping("/pizza/lista")
	public String telaLista(Model model) {		
		model.addAttribute("listagem", pizzaService.obterLista());
		
		return "pizza/lista";
	}
	
	@GetMapping("/pizza")
	public String telaCadastro() {
		return "pizza/cadastro";
	}
	
	@PostMapping("/pizza/incluir")
	public String incluirPizza(Pizza pizza) {
		pizzaService.incluir(pizza);
		
		return "redirect:/pizza/lista";
	}
	
	@GetMapping("/pizza/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		pizzaService.excluir(id);
		
		return "redirect:/pizza/lista";
	}
	
}
