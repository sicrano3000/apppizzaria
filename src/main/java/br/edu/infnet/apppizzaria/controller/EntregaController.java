package br.edu.infnet.apppizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntregaController {

	@GetMapping("/entrega/lista")
	public String telaLista() {
		return "entrega/lista";
	}

}
