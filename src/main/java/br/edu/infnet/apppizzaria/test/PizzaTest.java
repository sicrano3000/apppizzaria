package br.edu.infnet.apppizzaria.test;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.controller.PizzaController;
import br.edu.infnet.apppizzaria.model.domain.Pizza;
import br.edu.infnet.apppizzaria.model.exception.BordaNuloException;
import br.edu.infnet.apppizzaria.model.exception.ValorNegativoException;

@Component
public class PizzaTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		System.out.println("#pizza");
		
		var p1 = new Pizza();
		p1.setBorda("Catupiry");
		p1.setSabor("4 queijos");
		p1.setTipo("Massa fina");
		p1.setValor(50.);
		p1.setDescricao("Com bastante queijo");
		p1.setData(LocalDateTime.now());
		PizzaController.incluir(p1);
		try {
			p1.calcularVenda();
		} catch (BordaNuloException b) {
			System.out.println("[ERROR - PIZZA] -> " + b.getMessage());
		} catch (ValorNegativoException v) {
			System.out.println("[ERROR - PIZZA] -> " + v.getMessage());
		}
		
		var p2 = new Pizza();
		p2.setBorda("Tradicional");
		p2.setSabor("Calabresa");
		p2.setTipo("Massa Grossa");
		p2.setValor(40.);
		p2.setDescricao("Sem cebola");
		p2.setData(LocalDateTime.now());
		PizzaController.incluir(p2);
		try {
			p2.calcularVenda();
		} catch (BordaNuloException b) {
			System.out.println("[ERROR - PIZZA] -> " + b.getMessage());
		} catch (ValorNegativoException v) {
			System.out.println("[ERROR - PIZZA] -> " + v.getMessage());
		}
		
		var p3 = new Pizza();
		p3.setBorda("Cheddar");
		p3.setSabor("Frango com catupiry");
		p3.setTipo("Massa Fina");
		p3.setValor(45.);
		p3.setDescricao("Sem milho");
		p3.setData(LocalDateTime.now());
		PizzaController.incluir(p3);
		try {
			p3.calcularVenda();
		} catch (BordaNuloException b) {
			System.out.println("[ERROR - PIZZA] -> " + b.getMessage());
		} catch (ValorNegativoException v) {
			System.out.println("[ERROR - PIZZA] -> " + v.getMessage());
		}
		
		var p4 = new Pizza();
		p4.setBorda(null);
		p4.setSabor("Lombo canadense");
		p4.setTipo("Massa Fina");
		p4.setValor(60.);
		p4.setDescricao("Adicionar cebola");
		p4.setData(LocalDateTime.now());
		PizzaController.incluir(p4);
		try {
			p4.calcularVenda();
		} catch (BordaNuloException b) {
			System.out.println("[ERROR - PIZZA] -> " + b.getMessage());
		} catch (ValorNegativoException v) {
			System.out.println("[ERROR - PIZZA] -> " + v.getMessage());
		}
		
	}

}
