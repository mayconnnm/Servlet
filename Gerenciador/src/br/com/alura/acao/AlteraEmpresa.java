package br.com.alura.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.modelo.Banco;
import br.com.alura.modelo.Empresa;

public class AlteraEmpresa {

	public String exibe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Banco banco = new Banco();
		Empresa empresa = banco.buscaPorId(Integer.valueOf(id));
		request.setAttribute("empresa", empresa);

		return "forward:formAlteraEmpresa.jsp";
	}

	public String altera(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String dataEmpresa = request.getParameter("dataAbertura");
		Date data = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			data = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Banco banco = new Banco();
		Empresa empresa = banco.buscaPorId(Integer.valueOf(id));
		empresa.setNome(nome);
		empresa.setData(data);

		return "redirect:entrada?acao=listarEmpresa";
	}
}