package br.edu.infnet.apppizzaria.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.model.domain.Esfirra;
import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.exception.BordaNuloException;
import br.edu.infnet.apppizzaria.model.exception.ValorNegativoException;
import br.edu.infnet.apppizzaria.model.service.EsfirraService;

@Component
@Order(5)
public class EsfirraTest implements ApplicationRunner {
	
	@Autowired
	private EsfirraService esfirraService;

	@Override
	public void run(ApplicationArguments args) {
		var usuario = new Usuario();
		usuario.setId(1);
		
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		System.out.println("#esfirra");
		
		final var diretorio = "C:\\Projetos_Estudos\\";
		final var file = "produtos.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(diretorio.concat(file));
				BufferedReader leitura = new BufferedReader(fileReader);

				var linha = leitura.readLine();
				while(linha != null) {
					
					var campo = linha.split(";");
					
					if("esfirra".equalsIgnoreCase(campo[0])) {
						try {
							var esfirra = new Esfirra();
							esfirra.setBorda(campo[1]);
							esfirra.setSabor(campo[2]);
							esfirra.setTipo(campo[3]);
							esfirra.setValor(Double.valueOf(campo[4]));
							esfirra.setDescricao(campo[5]);
							esfirra.setData(LocalDateTime.now());
							esfirra.setUsuario(usuario);
							esfirraService.incluir(esfirra);
							
							esfirra.calcularVenda();
						} catch (BordaNuloException b) {
							System.out.println("[ERROR - ESFIRRA] -> " + b.getMessage());
						} catch (ValorNegativoException v) {
							System.out.println("[ERROR - ESFIRRA] -> " + v.getMessage());
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
