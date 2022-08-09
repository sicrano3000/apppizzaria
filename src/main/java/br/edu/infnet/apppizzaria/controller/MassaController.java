package br.edu.infnet.apppizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MassaController {

	@GetMapping("/massa/lista")
	public String telaLista() {
		return "massa/lista";
	}

}
