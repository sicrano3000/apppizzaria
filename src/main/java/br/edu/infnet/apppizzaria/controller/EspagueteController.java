package br.edu.infnet.apppizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppizzaria.model.domain.Espaguete;
import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.service.EspagueteService;

@Controller
public class EspagueteController {
	
	@Autowired
	private EspagueteService espagueteService;
	
	private String mensagem;

	@GetMapping("/espaguete/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("listagem", espagueteService.obterLista(usuario));
		model.addAttribute("mensagem", mensagem);
		
		return "espaguete/lista";
	}
	
	@GetMapping("/espaguete")
	public String telaCadastro() {
		return "espaguete/cadastro";
	}
	
	@PostMapping("/espaguete/incluir")
	public String incluirEspaguete(Espaguete espaguete, @SessionAttribute("user") Usuario usuario) {
		espaguete.setUsuario(usuario);
		espagueteService.incluir(espaguete);
		
		mensagem = "Inclusão do espaguete " + espaguete.getSabor() + " realizada com sucesso!";
		
		return "redirect:/espaguete/lista";
	}
	
	@GetMapping("/espaguete/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		try {
			espagueteService.excluir(id);
			
			mensagem = "exclusão do espaguete " + id + " realizada com sucesso!";
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão do espaguete " + id;
		}
		
		return "redirect:/espaguete/lista";
	}

}
