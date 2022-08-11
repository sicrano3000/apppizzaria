package br.edu.infnet.apppizzaria.test;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.model.domain.Pizza;

@Component
public class PizzaTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("#pizza");
		
		Pizza p1 = new Pizza();
		p1.setBorda("Catupiry");
		p1.setSabor("4 queijos");
		p1.setTipo("Massa fina");
		p1.setValor(50.);
		p1.setDescricao("Com bastante queijo");
		p1.setData(LocalDateTime.now());
		
		AppImpressao.relatorio("Pizza de " + p1.getSabor(), p1);
		
		Pizza p2 = new Pizza();
		p2.setBorda("Tradicional");
		p2.setSabor("Calabresa");
		p2.setTipo("Massa Grossa");
		p2.setValor(40.);
		p2.setDescricao("Sem cebola");
		p2.setData(LocalDateTime.now());
		
		AppImpressao.relatorio("Pizza de " + p2.getSabor(), p2);
		
		Pizza p3 = new Pizza();
		p3.setBorda("Cheddar");
		p3.setSabor("Frango com catupiry");
		p3.setTipo("Massa Fina");
		p3.setValor(45.);
		p3.setDescricao("Sem milho");
		p3.setData(LocalDateTime.now());
		
		AppImpressao.relatorio("Pizza de " + p3.getSabor(), p3);
		
	}

}
