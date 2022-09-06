package br.edu.infnet.apppizzaria.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Service
public class UsuarioService {
	
	private static Map<String, Usuario> mapaUsuario = new HashMap<>();
	
	public Usuario validar(String email, String senha) {
		var usuario = mapaUsuario.get(email);
		
		if (usuario != null && senha.equals(usuario.getSenha())) {
			return usuario;
		}
		
		return null;
	}
	
	public void excluir(String email) {
		mapaUsuario.remove(email);
	}
	
	public void incluir(Usuario usuario) {
		mapaUsuario.put(usuario.getEmail(), usuario);
		
		AppImpressao.relatorio("Inclusão do usuário " + usuario.getNome(), usuario);
	}
	
	public Collection<Usuario> obterLista() {
		return mapaUsuario.values();
	}

}
