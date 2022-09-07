package br.edu.infnet.apppizzaria.model.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.Esfirra;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Service
public class EsfirraService {
	
	private static Map<Integer, Esfirra> mapaEsfirra = new HashMap<>();
	private static Integer id = 1;
	
	public void incluir(Esfirra esfirra) {
		esfirra.setId(id++);
		esfirra.setData(LocalDateTime.now());
		mapaEsfirra.put(esfirra.getId(), esfirra);
		
		AppImpressao.relatorio("Esfirra de " + esfirra.getSabor(), esfirra);
	}
	
	public Collection<Esfirra> obterLista() {
		return mapaEsfirra.values();
	}
	
	public void excluir(Integer id) {
		mapaEsfirra.remove(id);
	}

}
