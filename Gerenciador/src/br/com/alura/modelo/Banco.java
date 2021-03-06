package br.com.alura.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();

	static {
		Empresa ep1 = new Empresa();
		Empresa ep2 = new Empresa();

		ep1.setId(1);
		ep2.setId(2);

		ep1.setNome("Alura");
		ep2.setNome("Caelum");

		String data1 = "01/01/2010";
		String data2 = "20/01/2020";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date dataF1 = null;
		Date dataF2 = null;

		try {
			dataF1 = sdf.parse(data1);
			dataF2 = sdf.parse(data2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ep1.setData(dataF1);
		ep2.setData(dataF2);

		listaEmpresas.add(ep1);
		listaEmpresas.add(ep2);
		
		Usuario use1 = new Usuario();
		Usuario use2 = new Usuario();

		use1.setLogin("maycon");
		use2.setLogin("bianca");

		use1.setSenha("123");
		use2.setSenha("000");
		
		listaUsuarios.add(use1);
		listaUsuarios.add(use2);
	}

	public void adiciona(Empresa empresa) {
		listaEmpresas.add(empresa);
	}

	public void remove(Integer id) {
		Iterator<Empresa> iterator = listaEmpresas.iterator();
		while (iterator.hasNext()) {
			Empresa empresa = iterator.next();
			if (empresa.getId() == id) {
				iterator.remove();
			}
		}
	}

	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(listaEmpresas);
	}

	public Empresa buscaPorId(Integer id) {
		for (Empresa empresa : listaEmpresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.igual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}