package br.edu.infnet.apppizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PizzaController {

	@GetMapping("/pizza/lista")
	public String telaLista() {
		return "pizza/lista";
	}
	
}
