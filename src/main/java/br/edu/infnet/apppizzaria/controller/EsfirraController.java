package br.edu.infnet.apppizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppizzaria.model.domain.Esfirra;
import br.edu.infnet.apppizzaria.model.service.EsfirraService;

@Controller
public class EsfirraController {
	
	@Autowired
	private EsfirraService esfirraService;

	@GetMapping("/esfirra/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", esfirraService.obterLista());
		
		return "esfirra/lista";
	}
	
	@GetMapping("/esfirra")
	public String telaCadastro() {
		return "esfirra/cadastro";
	}
	
	@PostMapping("/esfirra/incluir")
	public String incluirEsfirra(Esfirra esfirra) {
		esfirraService.incluir(esfirra);
		
		return "redirect:/esfirra/lista";
	}
	
	@GetMapping("/esfirra/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		esfirraService.excluir(id);
		
		return "redirect:/esfirra/lista";
	}

}
