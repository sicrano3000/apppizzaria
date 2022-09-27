package br.edu.infnet.apppizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppizzaria.model.domain.Pizza;
import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.service.PizzaService;

@Controller
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	private String mensagem;

	@GetMapping("/pizza/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {		
		model.addAttribute("listagem", pizzaService.obterLista(usuario));
		model.addAttribute("mensagem", mensagem);
		
		return "pizza/lista";
	}
	
	@GetMapping("/pizza")
	public String telaCadastro() {
		return "pizza/cadastro";
	}
	
	@PostMapping("/pizza/incluir")
	public String incluirPizza(Pizza pizza, @SessionAttribute("user") Usuario usuario) {
		pizza.setUsuario(usuario);
		pizzaService.incluir(pizza);
		
		mensagem = "Inclusão da pizza " + pizza.getSabor() + " realizada com sucesso!";
		
		return "redirect:/pizza/lista";
	}
	
	@GetMapping("/pizza/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		try {
			pizzaService.excluir(id);
			
			mensagem = "exclusão da pizza " + id + " realizada com sucesso!";
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão da pizza " + id;
		}
		
		return "redirect:/pizza/lista";
	}
	
}
