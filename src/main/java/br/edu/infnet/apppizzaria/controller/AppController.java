package br.edu.infnet.apppizzaria.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.apppizzaria.model.service.AppService;
import br.edu.infnet.apppizzaria.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AppService appService;
	
	@GetMapping("/")
	public String telaHome(Model model) {
		model.addAttribute("projeto", appService.obterProjeto());
		
		return "home";
	}
	
	@GetMapping("/login")
	public String telaLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		var usuario = usuarioService.validar(email, senha);
		
		if (usuario != null) {
			model.addAttribute("user", usuario);
			
			return "home";
		}
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession httpSession, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		httpSession.removeAttribute("user");
		
		return "redirect:/";
	}

}
