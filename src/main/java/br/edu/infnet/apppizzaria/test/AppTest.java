package br.edu.infnet.apppizzaria.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.model.domain.app.Atributo;
import br.edu.infnet.apppizzaria.model.domain.app.Classe;
import br.edu.infnet.apppizzaria.model.domain.app.Projeto;
import br.edu.infnet.apppizzaria.model.service.AppService;

@Component
public class AppTest implements ApplicationRunner {
	
	@Autowired
	private AppService appService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		final var diretorio = "C:\\Projetos_Estudos\\";
		final var file = "app.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(diretorio.concat(file));
				BufferedReader leitura = new BufferedReader(fileReader);
				
				Projeto projeto = null;
				List<Classe> classes = null;
				List<Atributo> atributos = null;

				var linha = leitura.readLine();
				while(linha != null) {	
					var campo = linha.split(";");
					
					switch (campo[0].toUpperCase()) {
					case "P":
						classes = new ArrayList<>();
						
						projeto = new Projeto();
						projeto.setNome(campo[1]);
						projeto.setDescricao(campo[2]);
						projeto.setAluno(campo[3]);
						projeto.setDisciplina(campo[4]);
						projeto.setClasses(classes);

						break;
						
					case "C":
						atributos = new ArrayList<>();
						
						var classe = new Classe();
						classe.setNome(campo[1]);
						classe.setAtributos(atributos);
						
						classes.add(classe);
						break;
						
					case "A":
						var atributo = new Atributo(campo[1], campo[2], campo[3]);
						
						atributos.add(atributo);
						break;
						
					default:
						System.out.println("Opção inválida!");
						break;
					}
					
					linha = leitura.readLine();
				}
				
				appService.incluir(projeto);
				
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
