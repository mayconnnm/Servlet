package br.com.alura.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 1830111717120637901L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idEmpresa = req.getParameter("id");
		Integer id = Integer.valueOf(idEmpresa);

		Banco banco = new Banco();
		Empresa empresa = banco.buscaPorId(id);

		RequestDispatcher rd = req.getRequestDispatcher("/formAlteraEmpresa.jsp");
		req.setAttribute("empresa", empresa);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idEmpresa = req.getParameter("id");
		String nome = req.getParameter("nome");
		String dataEmpresa = req.getParameter("dataAbertura");
		
		Integer id = Integer.valueOf(idEmpresa);
		Date data = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			data = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Banco banco = new Banco();
		Empresa empresa = banco.buscaPorId(id);
		empresa.setNome(nome);
		empresa.setData(data);

		resp.sendRedirect("listaEmpresas");
	}
}