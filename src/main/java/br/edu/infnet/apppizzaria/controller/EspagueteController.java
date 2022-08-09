package br.edu.infnet.apppizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EspagueteController {

	@GetMapping("/espaguete/lista")
	public String telaLista() {
		return "espaguete/lista";
	}

}
