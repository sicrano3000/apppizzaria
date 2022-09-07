package br.edu.infnet.apppizzaria.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.model.domain.Pizza;
import br.edu.infnet.apppizzaria.model.exception.BordaNuloException;
import br.edu.infnet.apppizzaria.model.exception.ValorNegativoException;
import br.edu.infnet.apppizzaria.model.service.PizzaService;

@Component
public class PizzaTest implements ApplicationRunner {
	
	@Autowired
	private PizzaService pizzaService;

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		System.out.println("#pizza");
		
		final var diretorio = "C:\\Projetos_Estudos\\";
		final var file = "pizza.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(diretorio.concat(file));
				BufferedReader leitura = new BufferedReader(fileReader);

				var linha = leitura.readLine();
				while(linha != null) {

					try {						
						var campo = linha.split(";");
						
						var pizza = new Pizza();
						pizza.setBorda(campo[0]);
						pizza.setSabor(campo[1]);
						pizza.setTipo(campo[2]);
						pizza.setValor(Double.valueOf(campo[3]));
						pizza.setDescricao(campo[4]);
						pizza.setData(LocalDateTime.now());
						pizzaService.incluir(pizza);
						
						pizza.calcularVenda();
					} catch (BordaNuloException b) {
						System.out.println("[ERROR - PIZZA] -> " + b.getMessage());
					} catch (ValorNegativoException v) {
						System.out.println("[ERROR - PIZZA] -> " + v.getMessage());
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
