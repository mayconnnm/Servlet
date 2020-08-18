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

public class NovaEmpresa {

	public String exibe() {
		return "forward:formNovaEmpresa.jsp";
	}
	
	public String salva(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");

		Date data = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setId(3);
		empresa.setNome(nomeEmpresa);
		empresa.setData(data);

		Banco banco = new Banco();
		banco.adiciona(empresa);

		return "redirect:entrada?acao=listarEmpresa";
	}
}