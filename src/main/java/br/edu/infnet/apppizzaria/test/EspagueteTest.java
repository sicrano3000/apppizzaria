package br.edu.infnet.apppizzaria.test;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.controller.EspagueteController;
import br.edu.infnet.apppizzaria.model.domain.Espaguete;
import br.edu.infnet.apppizzaria.model.exception.ValorNegativoException;

@Component
public class EspagueteTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		System.out.println("#espaguete");
		
		var e1 = new Espaguete();
		e1.setBorda("");
		e1.setSabor("Bolonhesa");
		e1.setTipo("Massa fina");
		e1.setValor(55.);
		e1.setDescricao("Com muito molho");
		e1.setData(LocalDateTime.now());
		EspagueteController.incluir(e1);
		try {
			e1.calcularVenda();
		} catch (ValorNegativoException v) {
			System.out.println("[ERROR - Espaguete] -> " + v.getMessage());
		}
		
		var e2 = new Espaguete();
		e2.setBorda(null);
		e2.setSabor("Frango");
		e2.setTipo("Ao dente");
		e2.setValor(50.);
		e2.setDescricao("Com milho");
		e2.setData(LocalDateTime.now());
		EspagueteController.incluir(e2);
		try {
			e2.calcularVenda();
		} catch (ValorNegativoException v) {
			System.out.println("[ERROR - Espaguete] -> " + v.getMessage());
		}
		
		var e3 = new Espaguete();
		e3.setBorda(null);
		e3.setSabor("4 queijos");
		e3.setTipo("Massa Grossa");
		e3.setValor(60.);
		e3.setDescricao("Com alho torrado");
		e3.setData(LocalDateTime.now());
		EspagueteController.incluir(e3);
		try {
			e3.calcularVenda();
		} catch (ValorNegativoException v) {
			System.out.println("[ERROR - Espaguete] -> " + v.getMessage());
		}
		
	}
}
