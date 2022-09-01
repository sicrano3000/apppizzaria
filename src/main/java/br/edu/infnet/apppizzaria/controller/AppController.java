package br.edu.infnet.apppizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	
	@GetMapping("/")
	public String telaHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String telaLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		var usuario = UsuarioController.validar(email, senha);
		
		if (usuario != null) {
			model.addAttribute("user", usuario.getNome());
			
			return "home";
		}
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("user", "");
		
		return "redirect:/";
	}

}
