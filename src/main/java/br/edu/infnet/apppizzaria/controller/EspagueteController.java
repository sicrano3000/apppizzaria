package br.edu.infnet.apppizzaria.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.apppizzaria.model.domain.Espaguete;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Controller
public class EspagueteController {
	
	private static Map<Integer, Espaguete> mapaEspaguete = new HashMap<>();
	private static Integer id = 1;
	
	public static void incluir(Espaguete espaguete) {
		espaguete.setId(id++);
		mapaEspaguete.put(espaguete.getId(), espaguete);
		
		AppImpressao.relatorio("Espaguete de " + espaguete.getSabor(), espaguete);
	}
	
	public static Collection<Espaguete> obterLista() {
		return mapaEspaguete.values();
	}
	
	public static void excluir(Integer id) {
		mapaEspaguete.remove(id);
	}

	@GetMapping("/espaguete/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", obterLista());
		
		return "espaguete/lista";
	}
	
	@GetMapping("/espaguete/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		excluir(id);
		
		return "redirect:/espaguete/lista";
	}

}
