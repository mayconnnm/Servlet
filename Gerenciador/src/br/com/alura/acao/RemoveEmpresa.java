package br.com.alura.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.modelo.Banco;

public class RemoveEmpresa {

	public String remove(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Banco banco = new Banco();
		banco.remove(Integer.valueOf(id));
		
		return "redirect:entrada?acao=listarEmpresa";
	}
}