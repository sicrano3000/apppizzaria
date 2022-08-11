package br.edu.infnet.apppizzaria.test;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.model.domain.Esfirra;

@Component
public class EsfirraTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("#esfirra");
		
		Esfirra e1 = new Esfirra();
		e1.setBorda("Calabresa");
		e1.setSabor("Bacon");
		e1.setTipo("Massa pobre");
		e1.setValor(15.);
		e1.setDescricao("Com oregano");
		e1.setData(LocalDateTime.now());
		
		AppImpressao.relatorio("Esfirra de " + e1.getSabor(), e1);
		
		Esfirra e2 = new Esfirra();
		e2.setBorda("Tradicional");
		e2.setSabor("Chocolate");
		e2.setTipo("Massa Grossa");
		e2.setValor(10.);
		e2.setDescricao("Com granulado");
		e2.setData(LocalDateTime.now());
		
		AppImpressao.relatorio("Esfirra de " + e2.getSabor(), e2);
		
		Esfirra e3 = new Esfirra();
		e3.setBorda("Cheddar");
		e3.setSabor("Frango");
		e3.setTipo("Massa Fina");
		e3.setValor(12.);
		e3.setDescricao("Sem milho");
		e3.setData(LocalDateTime.now());
		
		AppImpressao.relatorio("Esfirra de " + e3.getSabor(), e3);
		
	}
}
