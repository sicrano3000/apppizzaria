package br.edu.infnet.apppizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EsfirraController {

	@GetMapping("/esfirra/lista")
	public String telaLista() {
		return "esfirra/lista";
	}

}
