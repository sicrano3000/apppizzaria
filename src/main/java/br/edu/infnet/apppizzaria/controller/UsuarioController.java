package br.edu.infnet.apppizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping("/usuario/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", service.obterLista());
		
		return "usuario/lista";
	}
	
	@GetMapping("/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@PostMapping("/usuario/incluir")
	public String incluir(Usuario usuario) {
		service.incluir(usuario);
		
		return "redirect:/";
	}
	
	@GetMapping("/usuario/{email}/excluir")
	public String excluir(@PathVariable String email) {
		service.excluir(email);
		
		return "redirect:/usuario/lista";
	}

}
