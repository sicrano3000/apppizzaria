package br.edu.infnet.apppizzaria.test;

import java.time.LocalDateTime;
import java.util.HashSet;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.controller.EntregaController;
import br.edu.infnet.apppizzaria.model.domain.Cliente;
import br.edu.infnet.apppizzaria.model.domain.Entrega;
import br.edu.infnet.apppizzaria.model.domain.Esfirra;
import br.edu.infnet.apppizzaria.model.domain.Espaguete;
import br.edu.infnet.apppizzaria.model.domain.Pizza;
import br.edu.infnet.apppizzaria.model.exception.CPFInvalidoException;
import br.edu.infnet.apppizzaria.model.exception.CarrinhoVazioException;
import br.edu.infnet.apppizzaria.model.exception.ClienteNuloException;

@Component
public class EntregaTest implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) {
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("");
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
		
		try {
			var c1 = new Cliente("Jonathan", "jonathan@gmail.com", "11111111111");
			var e1 = new Entrega(c1, produtoE1);
			e1.setEndereco("Rua A");
			e1.setTempoPreparo(30);
			EntregaController.incluir(e1);
		} catch (CPFInvalidoException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		} catch (ClienteNuloException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		} catch (CarrinhoVazioException e) {
			System.out.println("[ERROR - CARRINHO] -> " + e.getMessage());
		}
		
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

		try {
			var c2 = new Cliente("Thairine", "thairine@gmail.com", "22222222222");
			var e2 = new Entrega(c2, produtoE2);
			e2.setEndereco("Rua B");
			e2.setTempoPreparo(80);
			EntregaController.incluir(e2);
		} catch (CPFInvalidoException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		} catch (ClienteNuloException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		} catch (CarrinhoVazioException e) {
			System.out.println("[ERROR - CARRINHO] -> " + e.getMessage());
		}		
		
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

		try {
			var c3 = new Cliente("Carol", "carol@gmail.com", "33333333333");
			var e3 = new Entrega(c3, produtoE3);
			e3.setEndereco("Rua C");
			e3.setTempoPreparo(50);
			EntregaController.incluir(e3);
		} catch (CPFInvalidoException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		} catch (ClienteNuloException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		} catch (CarrinhoVazioException e) {
			System.out.println("[ERROR - CARRINHO] -> " + e.getMessage());
		}
		
		//******************************************************************//
		
		var esfirra2 = new Esfirra();
		esfirra2.setBorda("Queijo");
		esfirra2.setSabor("4 queijos");
		esfirra2.setTipo("Massa fina");
		esfirra2.setValor(15.);
		esfirra2.setDescricao("Com oregano");
		esfirra2.setData(LocalDateTime.now());
		
		var produtoE4 = new HashSet<>();
		produtoE4.add(esfirra2);

		try {
			var c4 = new Cliente("Philipe", "philipe@gmail.com", null);
			var e4 = new Entrega(c4, produtoE4);
			e4.setEndereco("Rua D");
			e4.setTempoPreparo(30);
			EntregaController.incluir(e4);
		} catch (CPFInvalidoException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		} catch (ClienteNuloException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		} catch (CarrinhoVazioException e) {
			System.out.println("[ERROR - CARRINHO] -> " + e.getMessage());
		}
		
		//******************************************************************//
		
		var produtoE5 = new HashSet<>();

		try {
			var c5 = new Cliente("Philipe", "philipe@gmail.com", "55555555555");
			var e5 = new Entrega(c5, produtoE5);
			e5.setEndereco("Rua E");
			e5.setTempoPreparo(70);
			EntregaController.incluir(e5);
		} catch (CPFInvalidoException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		} catch (ClienteNuloException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		} catch (CarrinhoVazioException e) {
			System.out.println("[ERROR - CARRINHO] -> " + e.getMessage());
		}
		
		//******************************************************************//
		
		var pizza2 = new Pizza();
		pizza2.setBorda("Normal");
		pizza2.setSabor("Frango");
		pizza2.setTipo("Massa fina");
		pizza2.setValor(40.);
		pizza2.setDescricao("Com bastante queijo");
		pizza2.setData(LocalDateTime.now());
		
		var produtoE6 = new HashSet<>();
		produtoE6.add(pizza2);

		try {
			var e6 = new Entrega(null, produtoE6);
			e6.setEndereco("Rua D");
			e6.setTempoPreparo(30);
			EntregaController.incluir(e6);
		}catch (ClienteNuloException e) {
			System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
		} catch (CarrinhoVazioException e) {
			System.out.println("[ERROR - CARRINHO] -> " + e.getMessage());
		}
		
	}

}
