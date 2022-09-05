package br.edu.infnet.apppizzaria.controller;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppizzaria.model.domain.Esfirra;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Controller
public class EsfirraController {
	
	private static Map<Integer, Esfirra> mapaEsfirra = new HashMap<>();
	private static Integer id = 1;
	
	public static void incluir(Esfirra esfirra) {
		esfirra.setId(id++);
		esfirra.setData(LocalDateTime.now());
		mapaEsfirra.put(esfirra.getId(), esfirra);
		
		AppImpressao.relatorio("Esfirra de " + esfirra.getSabor(), esfirra);
	}
	
	public static Collection<Esfirra> obterLista() {
		return mapaEsfirra.values();
	}
	
	public static void excluir(Integer id) {
		mapaEsfirra.remove(id);
	}

	@GetMapping("/esfirra/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", obterLista());
		
		return "esfirra/lista";
	}
	
	@GetMapping("/esfirra")
	public String telaCadastro() {
		return "esfirra/cadastro";
	}
	
	@PostMapping("/esfirra/incluir")
	public String incluirEsfirra(Esfirra esfirra) {
		incluir(esfirra);
		
		return "redirect:/esfirra/lista";
	}
	
	@GetMapping("/esfirra/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		excluir(id);
		
		return "redirect:/esfirra/lista";
	}

}
