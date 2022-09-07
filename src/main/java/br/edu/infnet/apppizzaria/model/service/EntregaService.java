package br.edu.infnet.apppizzaria.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.Entrega;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Service
public class EntregaService {
	
	private static Map<Integer, Entrega> mapaEntrega = new HashMap<>();
	private static Integer id = 1;
	
	public void incluir(Entrega entrega) {
		entrega.setId(id++);
		mapaEntrega.put(entrega.getId(), entrega);
		
		AppImpressao.relatorio("Entrega para " + entrega.getEndereco(), entrega);
	}
	
	public Collection<Entrega> obterLista() {
		return mapaEntrega.values();
	}
	
	public void excluir(Integer id) {
		mapaEntrega.remove(id);
	}

}
