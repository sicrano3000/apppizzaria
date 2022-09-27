package br.edu.infnet.apppizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.service.MassaService;

@Controller
public class MassaController {
	
	@Autowired
	private MassaService massaService;
	
	private String mensagem;

	@GetMapping("/massa/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {		
		model.addAttribute("listagem", massaService.obterLista(usuario));
		model.addAttribute("mensagem", mensagem);
		
		return "massa/lista";
	}
	
	@GetMapping("/massa/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		try {
			massaService.excluir(id);
			
			mensagem = "exclusão da massa " + id + " realizada com sucesso!";
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão da massa " + id;
		}
		
		return "redirect:/massa/lista";
	}
	
}
