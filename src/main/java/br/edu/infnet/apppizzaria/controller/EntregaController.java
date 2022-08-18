package br.edu.infnet.apppizzaria.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.apppizzaria.model.domain.Entrega;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Controller
public class EntregaController {
	
	private static Map<Integer, Entrega> mapaEntrega = new HashMap<>();
	private static Integer id = 1;
	
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
	
	@GetMapping("/entrega/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		excluir(id);
		
		return "redirect:/entrega/lista";
	}

}
