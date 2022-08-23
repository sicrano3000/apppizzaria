package br.edu.infnet.apppizzaria.test;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.controller.EsfirraController;
import br.edu.infnet.apppizzaria.model.domain.Esfirra;
import br.edu.infnet.apppizzaria.model.exception.BordaNuloException;
import br.edu.infnet.apppizzaria.model.exception.ValorNegativoException;

@Component
public class EsfirraTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		System.out.println("#esfirra");
		
		var e1 = new Esfirra();
		e1.setBorda("Calabresa");
		e1.setSabor("Bacon");
		e1.setTipo("Massa pobre");
		e1.setValor(15.);
		e1.setDescricao("Com oregano");
		e1.setData(LocalDateTime.now());
		EsfirraController.incluir(e1);
		try {
			e1.calcularVenda();
		} catch (BordaNuloException b) {
			System.out.println("[ERROR - ESFIRRA] -> " + b.getMessage());
		} catch (ValorNegativoException v) {
			System.out.println("[ERROR - ESFIRRA] -> " + v.getMessage());
		}
		
		var e2 = new Esfirra();
		e2.setBorda("Tradicional");
		e2.setSabor("Chocolate");
		e2.setTipo("Massa Grossa");
		e2.setValor(10.);
		e2.setDescricao("Com granulado");
		e2.setData(LocalDateTime.now());
		EsfirraController.incluir(e2);
		try {
			e2.calcularVenda();
		} catch (BordaNuloException b) {
			System.out.println("[ERROR - ESFIRRA] -> " + b.getMessage());
		} catch (ValorNegativoException v) {
			System.out.println("[ERROR - ESFIRRA] -> " + v.getMessage());
		}
		
		var e3 = new Esfirra();
		e3.setBorda("Cheddar");
		e3.setSabor("Frango");
		e3.setTipo("Massa Fina");
		e3.setValor(12.);
		e3.setDescricao("Sem milho");
		e3.setData(LocalDateTime.now());
		EsfirraController.incluir(e3);
		try {
			e3.calcularVenda();
		} catch (BordaNuloException b) {
			System.out.println("[ERROR - ESFIRRA] -> " + b.getMessage());
		} catch (ValorNegativoException v) {
			System.out.println("[ERROR - ESFIRRA] -> " + v.getMessage());
		}
		
		var e4 = new Esfirra();
		e4.setBorda(null);
		e4.setSabor("Frango com catupiry");
		e4.setTipo("Massa Fina");
		e4.setValor(15.);
		e4.setDescricao("Sem milho");
		e4.setData(LocalDateTime.now());
		EsfirraController.incluir(e4);
		try {
			e4.calcularVenda();
		} catch (BordaNuloException b) {
			System.out.println("[ERROR - ESFIRRA] -> " + b.getMessage());
		} catch (ValorNegativoException v) {
			System.out.println("[ERROR - ESFIRRA] -> " + v.getMessage());
		}
		
	}
}
