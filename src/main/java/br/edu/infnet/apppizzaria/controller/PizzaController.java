package br.edu.infnet.apppizzaria.controller;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppizzaria.model.domain.Pizza;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Controller
public class PizzaController {
	
	private static Map<Integer, Pizza> mapaPizza = new HashMap<>();
	private static Integer id = 1;
	
	public static void incluir(Pizza pizza) {
		pizza.setId(id++);
		pizza.setData(LocalDateTime.now());
		mapaPizza.put(pizza.getId(), pizza);
		
		AppImpressao.relatorio("Pizza de " + pizza.getSabor(), pizza);
	}
	
	public static Collection<Pizza> obterLista() {
		return mapaPizza.values();
	}
	
	public static void excluir(Integer id) {
		mapaPizza.remove(id);
	}

	@GetMapping("/pizza/lista")
	public String telaLista(Model model) {		
		model.addAttribute("listagem", obterLista());
		
		return "pizza/lista";
	}
	
	@GetMapping("/pizza")
	public String telaCadastro() {
		return "pizza/cadastro";
	}
	
	@PostMapping("/pizza/incluir")
	public String incluirPizza(Pizza pizza) {
		incluir(pizza);
		
		return "redirect:/pizza/lista";
	}
	
	@GetMapping("/pizza/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		excluir(id);
		
		return "redirect:/pizza/lista";
	}
	
}
