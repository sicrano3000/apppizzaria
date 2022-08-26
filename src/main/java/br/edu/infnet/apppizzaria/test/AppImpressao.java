package br.edu.infnet.apppizzaria.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import br.edu.infnet.apppizzaria.interfaces.IPrinter;

public class AppImpressao {
	
	public static void relatorio(String mensagem, IPrinter printer) {		
		System.out.println(mensagem);
		
		printer.impressao();		
	}

	public static void main(String[] args) {
		var diretorio = "C:\\Projetos_Estudos\\";
		var file = "entrega.txt";
		
		System.out.println(diretorio.concat(file));
		
		try {
			try {
				FileReader fileReader = new FileReader(diretorio.concat(file));
				BufferedReader leitura = new BufferedReader(fileReader);

				var linha = leitura.readLine();
				while(linha != null) {
					System.out.println(linha);
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
