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
	
	private String mensagem;

	@GetMapping("/usuario/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", service.obterLista());
		model.addAttribute("mensagem", mensagem);
		
		return "usuario/lista";
	}
	
	@GetMapping("/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@PostMapping("/usuario/incluir")
	public String incluir(Usuario usuario) {
		service.incluir(usuario);
		
		mensagem = "Inclusão do usuário " + usuario.getNome() + " realizada com sucesso!";
		
		return "redirect:/";
	}
	
	@GetMapping("/usuario/{email}/excluir")
	public String excluir(@PathVariable String email) {
		try {
			service.excluir(email);
			
			mensagem = "exclusão do usuário " + email + " realizada com sucesso!";
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão do usuário " + email;
		}
		
		return "redirect:/usuario/lista";
	}

}
