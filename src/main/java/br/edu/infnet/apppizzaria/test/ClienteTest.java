package br.edu.infnet.apppizzaria.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.controller.ClienteController;
import br.edu.infnet.apppizzaria.model.domain.Cliente;

@Component
public class ClienteTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("#cliente");

		var c1 = new Cliente();
		c1.setNome("Jonathan");
		c1.setEmail("jonathan@gmail.com");
		c1.setCpf("11111111111");
		ClienteController.incluir(c1);

		var c2 = new Cliente();
		c2.setNome("Thairine");
		c2.setEmail("thairine@gmail.com");
		c2.setCpf("22222222222");
		ClienteController.incluir(c2);

		var c3 = new Cliente();
		c3.setNome("Carol");
		c3.setEmail("carol@gmail.com");
		c3.setCpf("33333333333");
		ClienteController.incluir(c3);

	}
}
