package br.edu.infnet.apppizzaria;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.model.domain.Entrega;

@Component
public class EntregaTest implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("#pedido");

		Entrega e1 = new Entrega();
		e1.setEndereco("Rua A");
		e1.setTempoPreparo(30);
		e1.setPrevisaoEntrega(LocalDateTime.now());
		System.out.println(e1);

		Entrega e2 = new Entrega();
		e2.setEndereco("Rua B");
		e2.setTempoPreparo(80);
		e2.setPrevisaoEntrega(LocalDateTime.now());
		System.out.println(e2);

		Entrega e3 = new Entrega();
		e3.setEndereco("Rua C");
		e3.setTempoPreparo(50);
		e3.setPrevisaoEntrega(LocalDateTime.now());
		System.out.println(e3);
	}

}
