package br.edu.infnet.apppizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppizzaria.model.domain.Esfirra;
import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.service.EsfirraService;

@Controller
public class EsfirraController {
	
	@Autowired
	private EsfirraService esfirraService;
	
	private String mensagem;

	@GetMapping("/esfirra/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("listagem", esfirraService.obterLista(usuario));
		model.addAttribute("mensagem", mensagem);
		
		return "esfirra/lista";
	}
	
	@GetMapping("/esfirra")
	public String telaCadastro() {
		return "esfirra/cadastro";
	}
	
	@PostMapping("/esfirra/incluir")
	public String incluirEsfirra(Esfirra esfirra, @SessionAttribute("user") Usuario usuario) {
		esfirra.setUsuario(usuario);
		esfirraService.incluir(esfirra);
		
		mensagem = "Inclusão da esfirra " + esfirra.getSabor() + " realizada com sucesso!";
		
		return "redirect:/esfirra/lista";
	}
	
	@GetMapping("/esfirra/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		try {
			esfirraService.excluir(id);
			
			mensagem = "exclusão da esfirra " + id + " realizada com sucesso!";
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão da esfirra " + id;
		}
		
		return "redirect:/esfirra/lista";
	}

}
