package br.edu.infnet.apppizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

	@GetMapping("/cliente/lista")
	public String telaLista() {
		return "cliente/lista";
	}

}
