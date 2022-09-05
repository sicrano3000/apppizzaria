package br.edu.infnet.apppizzaria.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppizzaria.model.domain.Cliente;
import br.edu.infnet.apppizzaria.model.domain.Entrega;
import br.edu.infnet.apppizzaria.model.domain.Pizza;
import br.edu.infnet.apppizzaria.model.exception.CPFInvalidoException;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Controller
public class EntregaController {
	
	private static Map<Integer, Entrega> mapaEntrega = new HashMap<>();
	private static Integer id = 1;
	
	private Cliente cliente;
	private Pizza carrinho;
	
	public static void incluir(Entrega entrega) {
		entrega.setId(id++);
		mapaEntrega.put(entrega.getId(), entrega);
		
		AppImpressao.relatorio("Entrega para " + entrega.getEndereco(), entrega);
	}
	
	public static Collection<Entrega> obterLista() {
		return mapaEntrega.values();
	}
	
	public static void excluir(Integer id) {
		mapaEntrega.remove(id);
	}

	@GetMapping("/entrega/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", obterLista());
		
		return "entrega/lista";
	}
	
	@GetMapping("/entrega")
	public String telaCadastro(Model model) throws CPFInvalidoException {
		model.addAttribute("cliente", mockCliente());
		model.addAttribute("carrinho", mockCarrinho());
		return "entrega/cadastro";
	}
	
	@PostMapping("/entrega/incluir")
	public String incluirEntrega(Entrega entrega) throws CPFInvalidoException {
		incluir(entrega);
		
		return "redirect:/entrega/lista";
	}
	
	@GetMapping("/entrega/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		excluir(id);
		
		return "redirect:/entrega/lista";
	}
	
	public Cliente mockCliente() throws CPFInvalidoException {
		return new Cliente("Nome Mock", "Email Mock", "11111111111");
	}
	
	public Pizza mockCarrinho() {
		return new Pizza("Pizza Mock", 5d, "Sabor Mock");
	}

}
