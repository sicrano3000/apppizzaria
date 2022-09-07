package br.edu.infnet.apppizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppizzaria.model.domain.Espaguete;
import br.edu.infnet.apppizzaria.model.service.EspagueteService;

@Controller
public class EspagueteController {
	
	@Autowired
	private EspagueteService espagueteService;

	@GetMapping("/espaguete/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", espagueteService.obterLista());
		
		return "espaguete/lista";
	}
	
	@GetMapping("/espaguete")
	public String telaCadastro() {
		return "espaguete/cadastro";
	}
	
	@PostMapping("/espaguete/incluir")
	public String incluirEspaguete(Espaguete espaguete) {
		espagueteService.incluir(espaguete);
		
		return "redirect:/espaguete/lista";
	}
	
	@GetMapping("/espaguete/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		espagueteService.excluir(id);
		
		return "redirect:/espaguete/lista";
	}

}
