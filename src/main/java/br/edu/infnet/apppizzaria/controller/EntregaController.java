package br.edu.infnet.apppizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppizzaria.model.domain.Entrega;
import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.service.ClienteService;
import br.edu.infnet.apppizzaria.model.service.EntregaService;
import br.edu.infnet.apppizzaria.service.ProdutoService;

@Controller
public class EntregaController {
	
	@Autowired
	private EntregaService entregaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	private String mensagem;
	
	@GetMapping("/entrega")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("clientes", clienteService.obterLista(usuario));
		model.addAttribute("produtos", produtoService.obterLista(usuario));
		model.addAttribute("mensagem", mensagem);
		
		return "entrega/cadastro";
	}

	@GetMapping("/entrega/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("listagem", entregaService.obterLista(usuario));
		
		return "entrega/lista";
	}
	
	@GetMapping("/entrega/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		try {
			entregaService.excluir(id);
			
			mensagem = "exclusão da entrega do cliente " + id + " realizada com sucesso!";
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão da entrega do cliente " + id;
		}
		
		return "redirect:/entrega/lista";
	}
	
	@PostMapping("/entrega/incluir")
	public String inclusao(Entrega entrega, @SessionAttribute("user") Usuario usuario) {		
		entrega.setUsuario(usuario);
		entregaService.incluir(entrega);
		
		mensagem = "Inclusão da entrega do cliente " + entrega.getCliente() + " realizada com sucesso!";
		
		return "redirect:/entrega/lista";
	}

}
