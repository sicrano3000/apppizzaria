package br.edu.infnet.apppizzaria.model.domain.app;

import java.util.List;

import br.edu.infnet.apppizzaria.interfaces.IPrinter;

public class Projeto implements IPrinter {

	private String nome;
	private String descricao;
	private String aluno;
	private String disciplina;
	private List<Classe> classes;

	public List<Classe> getClasses() {
		return classes;
	}
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	@Override
	public void impressao() {
		System.out.println(" - " + nome + " | " + descricao + " | " + aluno + " | " + disciplina);
		
		classes.forEach(classe -> classe.impressao());
	}

}
