package br.edu.infnet.apppizzaria.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		pizza.setSabor("Pizza de 4 queijos");
		pizza.setTipo("Massa fina");
		pizza.setValor(50.);
		pizza.setDescricao("Com bastante queijo");
		pizza.setData(LocalDateTime.now());
		
		var esfirra = new Esfirra();
		esfirra.setBorda("Calabresa");
		esfirra.setSabor("Esfirra de Bacon");
		esfirra.setTipo("Massa pobre");
		esfirra.setValor(15.);
		esfirra.setDescricao("Com oregano");
		esfirra.setData(LocalDateTime.now());
		
		var espaguete = new Espaguete();
		espaguete.setBorda("");
		espaguete.setSabor("Espaguete à Bolonhesa");
		espaguete.setTipo("Massa fina");
		espaguete.setValor(55.);
		espaguete.setDescricao("Com muito molho");
		espaguete.setData(LocalDateTime.now());
		
		var produtoE1 = new HashSet<>();
		produtoE1.add(pizza);
		produtoE1.add(esfirra);
		produtoE1.add(espaguete);
		
		final var diretorio = "C:\\Projetos_Estudos\\";
		final var file = "entrega.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(diretorio.concat(file));
				BufferedReader leitura = new BufferedReader(fileReader);

				var linha = leitura.readLine();
				while(linha != null) {

					try {						
						var campo = linha.split(";");
						
						var cliente = new Cliente(campo[0], campo[1], campo[2]);
						var entrega = new Entrega(cliente, produtoE1);
						entrega.setEndereco(campo[3]);
						entrega.setTempoPreparo(Integer.valueOf(campo[4]));
						EntregaController.incluir(entrega);
					} catch (CPFInvalidoException e) {
						System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
					} catch (ClienteNuloException e) {
						System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
					} catch (CarrinhoVazioException e) {
						System.out.println("[ERROR - CARRINHO] -> " + e.getMessage());
					}
					
					linha = leitura.readLine();
				}
				
				leitura.close();
				fileReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("[ERRO] - O arquivo não existe.");
			} catch (IOException e) {
				System.out.println("[ERRO] - Houve um erro ao fechar o arquivo.");
			}
		} finally {
			System.out.println("Terminou!!!");
		}
		
	}

}
