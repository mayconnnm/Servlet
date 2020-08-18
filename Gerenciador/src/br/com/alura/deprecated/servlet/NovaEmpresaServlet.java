package br.com.alura.deprecated.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.modelo.Banco;
import br.com.alura.modelo.Empresa;

//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 3066343461246953394L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
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
		
		response.sendRedirect("listaEmpresas");
		
		// Despachando para
		// RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		
		// Despachando para outro servlet
		// RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		
		// Pendurando um valor
		// request.setAttribute("nome", empresa.getNome());
		// request.setAttribute("dataAbertura", empresa.getData());
		
		// Despachando o que
		// rd.forward(request, response);
	
		// PrintWriter out = response.getWriter();
		// out.println("<html>");
		// out.println("<head>");
		// out.println("</head>");
		// out.println("<body>");
		// out.println("Empresa " + nomeEmpresa + " cadastrada com sucesso!");
		// out.println("</body>");
		// out.println("</html>");
	}

}