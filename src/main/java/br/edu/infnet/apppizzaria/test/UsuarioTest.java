package br.edu.infnet.apppizzaria.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppizzaria.controller.UsuarioController;
import br.edu.infnet.apppizzaria.model.domain.Usuario;

@Component
public class UsuarioTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		var usuario = new Usuario();
		usuario.setNome("Admin");
		usuario.setEmail("admin@admin.com");
		usuario.setSenha("123");
		
		UsuarioController.incluir(usuario);
	}

}
