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

import br.edu.infnet.apppizzaria.model.domain.Espaguete;
import br.edu.infnet.apppizzaria.model.exception.ValorNegativoException;
import br.edu.infnet.apppizzaria.model.service.EspagueteService;

@Component
public class EspagueteTest implements ApplicationRunner {
	
	@Autowired
	private EspagueteService espagueteService;

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		System.out.println("#espaguete");

		final var diretorio = "C:\\Projetos_Estudos\\";
		final var file = "produtos.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(diretorio.concat(file));
				BufferedReader leitura = new BufferedReader(fileReader);

				var linha = leitura.readLine();				
				while(linha != null) {
					
					var campo = linha.split(";");
				
					if("espaguete".equalsIgnoreCase(campo[0])) {
						try {						
							var espaguete = new Espaguete();
							espaguete.setBorda(campo[1]);
							espaguete.setSabor(campo[2]);
							espaguete.setTipo(campo[3]);
							espaguete.setValor(Double.valueOf(campo[4]));
							espaguete.setDescricao(campo[5]);
							espaguete.setData(LocalDateTime.now());
							espagueteService.incluir(espaguete);
							
							espaguete.calcularVenda();
						} catch (ValorNegativoException v) {
							System.out.println("[ERROR - Espaguete] -> " + v.getMessage());
						}
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
