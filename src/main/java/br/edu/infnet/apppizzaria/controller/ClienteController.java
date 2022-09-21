package br.edu.infnet.apppizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppizzaria.model.domain.Cliente;
import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/cliente/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("listagem", clienteService.obterLista(usuario));
		
		return "cliente/lista";
	}
	
	@GetMapping("/cliente")
	public String telaCadastro() {
		return "cliente/cadastro";
	}
	
	@PostMapping("/cliente/incluir")
	public String incluirCliente(Cliente cliente, @SessionAttribute("user") Usuario usuario) {
		cliente.setUsuario(usuario);
		
		clienteService.incluir(cliente);
		
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/cliente/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		clienteService.excluir(id);
		
		return "redirect:/cliente/lista";
	}

}
