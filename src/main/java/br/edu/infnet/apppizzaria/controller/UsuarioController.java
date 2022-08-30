package br.edu.infnet.apppizzaria.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Controller
public class UsuarioController {
	
	private static Map<String, Usuario> mapaUsuario = new HashMap<>();
	
	public static void incluir(Usuario usuario) {
		mapaUsuario.put(usuario.getEmail(), usuario);
		
		AppImpressao.relatorio("Inclusão do usuário " + usuario.getNome(), usuario);
	}
	
	public static Collection<Usuario> obterLista() {
		return mapaUsuario.values();
	}

	@GetMapping("/usuario/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", obterLista());
		
		return "usuario/lista";
	}

}
