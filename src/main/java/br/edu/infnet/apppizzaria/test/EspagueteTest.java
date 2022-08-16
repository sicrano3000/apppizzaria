package br.edu.infnet.apppizzaria.test;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.model.domain.Espaguete;

@Component
public class EspagueteTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("#espaguete");
		
		var e1 = new Espaguete();
		e1.setBorda("");
		e1.setSabor("Bolonhesa");
		e1.setTipo("Massa fina");
		e1.setValor(55.);
		e1.setDescricao("Com muito molho");
		e1.setData(LocalDateTime.now());
		
		AppImpressao.relatorio("Espaguete de " + e1.getSabor(), e1);
		
		var e2 = new Espaguete();
		e2.setBorda(null);
		e2.setSabor("Frango");
		e2.setTipo("Ao dente");
		e2.setValor(50.);
		e2.setDescricao("Com milho");
		e2.setData(LocalDateTime.now());
		
		AppImpressao.relatorio("Espaguete de " + e2.getSabor(), e2);
		
		var e3 = new Espaguete();
		e3.setBorda(null);
		e3.setSabor("4 queijos");
		e3.setTipo("Massa Grossa");
		e3.setValor(60.);
		e3.setDescricao("Com alho torrado");
		e3.setData(LocalDateTime.now());
		
		AppImpressao.relatorio("Espaguete de " + e3.getSabor(), e3);
		
	}
}
