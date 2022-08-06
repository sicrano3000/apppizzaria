package br.edu.infnet.apppizzaria.test;

import br.edu.infnet.apppizzaria.model.domain.Cliente;

public class ClienteTest {
	
	public static void main(String[] args) {
		Cliente c1 = new Cliente("Jonathan", "11111111111", "jonathan@gmail.com");
		System.out.println(c1);
		
		Cliente c2 = new Cliente("Thairine", "22222222222", "thairine@gmail.com");
		System.out.println(c2);
		
		Cliente c3 = new Cliente("Caroline", "33333333333", "caroline@gmail.com");
		System.out.println(c3);
	}

}
