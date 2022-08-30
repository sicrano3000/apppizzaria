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
		System.out.println("[email " +email+ "]");
		System.out.println("[senha " +senha+ "]");
		
		if (email.equalsIgnoreCase(senha)) {
			var nome = "Admin";
			model.addAttribute("user", nome);
			
			return "home";
		}
		
		return "/login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("user", "");
		
		return "redirect:/";
	}

}
