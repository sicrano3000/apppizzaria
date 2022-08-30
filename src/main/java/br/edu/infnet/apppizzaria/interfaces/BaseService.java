package br.edu.infnet.apppizzaria.interfaces;


public interface BaseService<T> {
	
	void incluir(T obj);
	
	void excluir(Integer id);

}
