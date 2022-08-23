package br.edu.infnet.apppizzaria.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.controller.ClienteController;
import br.edu.infnet.apppizzaria.model.domain.Cliente;
import br.edu.infnet.apppizzaria.model.exception.CPFInvalidoException;

@Component
public class ClienteTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		System.out.println("#cliente");

		try {
			var c1 = new Cliente("Jonathan", "jonathan@gmail.com", "11111111111");
			ClienteController.incluir(c1);
		} catch (CPFInvalidoException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		}

		try {
			var c2 = new Cliente("Thairine", "thairine@gmail.com", "22222222222");
			ClienteController.incluir(c2);
		} catch (CPFInvalidoException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		}

		try {
			var c3 = new Cliente("Carol", "carol@gmail.com", "33333333333");
			ClienteController.incluir(c3);
		} catch (CPFInvalidoException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		}

		try {
			var c4 = new Cliente("Philipe", "philipe@gmail.com", "");
			ClienteController.incluir(c4);
		} catch (CPFInvalidoException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		}
		
		try {
			var c5 = new Cliente("Amaral", "amaral@gmail.com", null);
			ClienteController.incluir(c5);
		} catch (CPFInvalidoException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		}
		
	}
}
