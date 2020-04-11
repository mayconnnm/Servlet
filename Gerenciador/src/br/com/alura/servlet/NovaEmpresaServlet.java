package br.com.alura.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 3066343461246953394L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		String nomeEmpresa = request.getParameter("nome");

		Empresa empresa = new Empresa();
		empresa.setId(1);
		empresa.setNome(nomeEmpresa);

		Banco banco = new Banco();
		banco.adiciona(empresa);

		// Despachando para
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		// Pendurando um valor 
		request.setAttribute("nome", empresa.getNome());
		// Despachando o que
		rd.forward(request, response);

//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("Empresa " + nomeEmpresa + " cadastrada com sucesso!");
//		out.println("</body>");
//		out.println("</html>");
	}

}