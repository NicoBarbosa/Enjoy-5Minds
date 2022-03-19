package br.com.fiap.enjoy.teste;

import javax.persistence.Persistence;

public class TesteEnjoy {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("Enjoy-5Minds").createEntityManager();
	}

}
