package br.com.alura.deprecated.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.modelo.Banco;

//@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = -3728441045549469200L;

	@Override
	protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {

		String removeEmpresa = req.getParameter("id");
		Integer id = Integer.valueOf(removeEmpresa);

		Banco banco = new Banco();
		banco.remove(id);

		resp.sendRedirect("listaEmpresas");
	}
}