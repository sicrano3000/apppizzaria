package br.edu.infnet.apppizzaria.test;

import java.time.LocalDateTime;
import java.util.HashSet;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.model.domain.Cliente;
import br.edu.infnet.apppizzaria.model.domain.Entrega;
import br.edu.infnet.apppizzaria.model.domain.Esfirra;
import br.edu.infnet.apppizzaria.model.domain.Espaguete;
import br.edu.infnet.apppizzaria.model.domain.Pizza;

@Component
public class EntregaTest implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("#entrega");
		
		var pizza = new Pizza();
		pizza.setBorda("Catupiry");
		pizza.setSabor("4 queijos");
		pizza.setTipo("Massa fina");
		pizza.setValor(50.);
		pizza.setDescricao("Com bastante queijo");
		pizza.setData(LocalDateTime.now());
		
		var produtoE1 = new HashSet<>();
		produtoE1.add(pizza);
		
		var c1 = new Cliente("Jonathan", "jonathan@gmail.com", "11111111111");
		var e1 = new Entrega(c1);
		e1.setEndereco("Rua A");
		e1.setTempoPreparo(30);
		e1.setCarrinho(produtoE1);
		AppImpressao.relatorio("Entrega ", e1);
		
		//******************************************************************//
		
		var esfirra = new Esfirra();
		esfirra.setBorda("Calabresa");
		esfirra.setSabor("Bacon");
		esfirra.setTipo("Massa pobre");
		esfirra.setValor(15.);
		esfirra.setDescricao("Com oregano");
		esfirra.setData(LocalDateTime.now());
		
		var produtoE2 = new HashSet<>();
		produtoE2.add(pizza);
		produtoE2.add(esfirra);

		var c2 = new Cliente("Thairine", "thairine@gmail.com", "22222222222");				
		var e2 = new Entrega(c2);
		e2.setEndereco("Rua B");
		e2.setTempoPreparo(80);
		e2.setCarrinho(produtoE2);
		AppImpressao.relatorio("Entrega ", e2);
		
		//******************************************************************//
		
		var espaguete = new Espaguete();
		espaguete.setBorda("");
		espaguete.setSabor("Bolonhesa");
		espaguete.setTipo("Massa fina");
		espaguete.setValor(55.);
		espaguete.setDescricao("Com muito molho");
		espaguete.setData(LocalDateTime.now());
		
		var espaguete1 = new Espaguete();
		espaguete1.setBorda("");
		espaguete1.setSabor("Bolonhesa");
		espaguete1.setTipo("Massa fina");
		espaguete1.setValor(55.);
		espaguete1.setDescricao("Com muito molho");
		espaguete1.setData(LocalDateTime.now());
		
		var produtoE3 = new HashSet<>();
		produtoE3.add(pizza);
		produtoE3.add(esfirra);
		produtoE3.add(espaguete);
		produtoE3.add(espaguete1);

		var c3 = new Cliente("Carol", "carol@gmail.com", "33333333333");				
		var e3 = new Entrega(c3);
		e3.setEndereco("Rua C");
		e3.setTempoPreparo(50);
		e3.setCarrinho(produtoE3);
		AppImpressao.relatorio("Entrega ", e3);
		
	}

}
