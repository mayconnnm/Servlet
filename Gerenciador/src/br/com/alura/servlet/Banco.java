package br.com.alura.servlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<>();

	static {
		Empresa ep1 = new Empresa();
		Empresa ep2 = new Empresa();

		ep1.setId(1);
		ep2.setId(2);

		ep1.setNome("Alura");
		ep2.setNome("Caelum");

		listaEmpresas.add(ep1);
		listaEmpresas.add(ep2);
	}

	public void adiciona(Empresa empresa) {
		listaEmpresas.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(listaEmpresas);
	}

}
