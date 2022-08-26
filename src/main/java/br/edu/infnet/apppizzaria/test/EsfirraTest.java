package br.edu.infnet.apppizzaria.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		
		final var diretorio = "C:\\Projetos_Estudos\\";
		final var file = "esfirra.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(diretorio.concat(file));
				BufferedReader leitura = new BufferedReader(fileReader);

				var linha = leitura.readLine();
				while(linha != null) {

					try {						
						var campo = linha.split(";");
						
						var esfirra = new Esfirra();
						esfirra.setBorda(campo[0]);
						esfirra.setSabor(campo[1]);
						esfirra.setTipo(campo[2]);
						esfirra.setValor(Double.valueOf(campo[3]));
						esfirra.setDescricao(campo[4]);
						esfirra.setData(LocalDateTime.now());
						EsfirraController.incluir(esfirra);
						
						esfirra.calcularVenda();
					} catch (BordaNuloException b) {
						System.out.println("[ERROR - ESFIRRA] -> " + b.getMessage());
					} catch (ValorNegativoException v) {
						System.out.println("[ERROR - ESFIRRA] -> " + v.getMessage());
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
