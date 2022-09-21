package br.edu.infnet.apppizzaria.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.service.UsuarioService;

@Component
@Order(1)
public class UsuarioTest implements ApplicationRunner {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private Usuario usuario;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		usuario = new Usuario();
		usuario.setNome("Admin");
		usuario.setEmail("admin@admin.com");
		usuario.setSenha("123");
		
		usuarioService.incluir(usuario);
		
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		System.out.println("#usuario");
		
		final var diretorio = "C:\\Projetos_Estudos\\";
		final var file = "usuario.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(diretorio.concat(file));
				BufferedReader leitura = new BufferedReader(fileReader);

				var linha = leitura.readLine();
				while(linha != null) {	
					var campo = linha.split(";");
					
					usuario = new Usuario();
					usuario.setNome(campo[0]);
					usuario.setEmail(campo[1]);
					usuario.setSenha(campo[2]);
					
					usuarioService.incluir(usuario);
					
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
