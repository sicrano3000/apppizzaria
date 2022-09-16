package br.edu.infnet.apppizzaria.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.model.domain.Cliente;
import br.edu.infnet.apppizzaria.model.domain.Entrega;
import br.edu.infnet.apppizzaria.model.domain.Espaguete;
import br.edu.infnet.apppizzaria.model.exception.CPFInvalidoException;
import br.edu.infnet.apppizzaria.model.exception.CarrinhoVazioException;
import br.edu.infnet.apppizzaria.model.exception.ClienteNuloException;
import br.edu.infnet.apppizzaria.model.service.EntregaService;

@Component
public class EntregaTest implements ApplicationRunner {
	
	@Autowired
	private EntregaService entregaService;
	
	@Override
	public void run(ApplicationArguments args) {
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		System.out.println("#entrega");
		
		final var diretorio = "C:\\Projetos_Estudos\\";
		final var file = "entregas.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(diretorio.concat(file));
				BufferedReader leitura = new BufferedReader(fileReader);

				Set<Object> produtos = null;
				var entregas = new ArrayList<Entrega>();
				var linha = leitura.readLine();	
				Cliente cliente = null;
				
				while(linha != null) {					

					var campo = linha.split(";");
					
					try {
						switch (campo[0]) {
							case "cliente":
								produtos = new HashSet<>();
								cliente = new Cliente(campo[1], campo[2], campo[3]);
								
								break;
							case "espaguete":
								var espaguete = new Espaguete();
								espaguete.setBorda(campo[1]);
								espaguete.setSabor(campo[2]);
								espaguete.setTipo(campo[3]);
								espaguete.setValor(Double.valueOf(campo[4]));
								espaguete.setDescricao(campo[5]);
								espaguete.setData(LocalDateTime.now());
								
								produtos.add(espaguete);
								
								break;
							case "esfirra":
								var esfirra = new Espaguete();
								esfirra.setBorda(campo[1]);
								esfirra.setSabor(campo[2]);
								esfirra.setTipo(campo[3]);
								esfirra.setValor(Double.valueOf(campo[4]));
								esfirra.setDescricao(campo[5]);
								esfirra.setData(LocalDateTime.now());
								
								produtos.add(esfirra);
								
								break;
							case "pizza":
								var pizza = new Espaguete();
								pizza.setBorda(campo[1]);
								pizza.setSabor(campo[2]);
								pizza.setTipo(campo[3]);
								pizza.setValor(Double.valueOf(campo[4]));
								pizza.setDescricao(campo[5]);
								pizza.setData(LocalDateTime.now());
								
								produtos.add(pizza);
								
								break;
							case "entrega":
								
								var entrega = new Entrega(cliente, produtos);
								entrega.setEndereco(campo[4]);
								entrega.setTempoPreparo(Integer.valueOf(campo[5]));
								
								entregas.add(entrega);
								
								break;
		
							default:
								break;
						}
						
						linha = leitura.readLine();

					} catch (CPFInvalidoException e) {
						System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
					} catch (ClienteNuloException e) {
						System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
					} catch (CarrinhoVazioException e) {
						System.out.println("[ERROR - CARRINHO] -> " + e.getMessage());
					}
					
				}
				
				entregas.forEach(e -> entregaService.incluir(e));
				
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
