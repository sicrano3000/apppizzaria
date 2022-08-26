package br.edu.infnet.apppizzaria.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.controller.ClienteController;
import br.edu.infnet.apppizzaria.model.domain.Cliente;
import br.edu.infnet.apppizzaria.model.exception.CPFInvalidoException;

@Component
public class ClienteTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		System.out.println("#cliente");
		
		final var diretorio = "C:\\Projetos_Estudos\\";
		final var file = "cliente.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(diretorio.concat(file));
				BufferedReader leitura = new BufferedReader(fileReader);

				var linha = leitura.readLine();
				while(linha != null) {

					try {						
						var campo = linha.split(";");
						
						var cliente = new Cliente(campo[0], campo[1], campo[2]);
						ClienteController.incluir(cliente);
					} catch (CPFInvalidoException e) {
						System.out.println("[ERROR - CLIENTE] -> " + e.getMessage());
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
