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
	
	private String mensagem;

	@GetMapping("/cliente/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {		
		model.addAttribute("listagem", clienteService.obterLista(usuario));
		model.addAttribute("mensagem", mensagem);
		
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
		
		mensagem = "Inclusão do cliente " + cliente.getNome() + " realizada com sucesso!";
		
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/cliente/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		try {
			clienteService.excluir(id);
			
			mensagem = "exclusão do cliente " + id + " realizada com sucesso!";
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão do cliente " + id;
		}
		
		return "redirect:/cliente/lista";
	}

}
