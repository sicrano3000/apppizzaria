package br.edu.infnet.apppizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.apppizzaria.model.service.EntregaService;

@Controller
public class EntregaController {
	
	@Autowired
	private EntregaService entregaService;

	@GetMapping("/entrega/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", entregaService.obterLista());
		
		return "entrega/lista";
	}
	
	@GetMapping("/entrega/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		entregaService.excluir(id);
		
		return "redirect:/entrega/lista";
	}

}
