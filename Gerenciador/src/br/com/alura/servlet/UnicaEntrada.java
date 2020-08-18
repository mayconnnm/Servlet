package br.com.alura.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.acao.AlteraEmpresa;
import br.com.alura.acao.ListaEmpresas;
import br.com.alura.acao.Login;
import br.com.alura.acao.LoginForm;
import br.com.alura.acao.Logout;
import br.com.alura.acao.NovaEmpresa;
import br.com.alura.acao.RemoveEmpresa;

//@WebServlet("/entrada")
public class UnicaEntrada extends HttpServlet {

	private static final long serialVersionUID = 8578870336564410558L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String nomeJSP = null;

		if (acao.equals("criarEmpresa")) {
			NovaEmpresa novaEmpresa = new NovaEmpresa();
			nomeJSP = novaEmpresa.exibe();
		} else if (acao.equals("salvarEmpresa")) {
			NovaEmpresa novaEmpresa = new NovaEmpresa();
			nomeJSP = novaEmpresa.salva(request, response);
		} else if (acao.equals("listarEmpresa")) {
			ListaEmpresas listaEmpresas = new ListaEmpresas();
			nomeJSP = listaEmpresas.lista(request, response);
		} else if (acao.equals("detalhesEmpresa")) {
			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
			nomeJSP = alteraEmpresa.exibe(request, response);
		} else if (acao.equals("alterarEmpresa")) {
			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
			nomeJSP = alteraEmpresa.altera(request, response);
		} else if (acao.equals("removerEmpresa")) {
			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
			nomeJSP = removeEmpresa.remove(request, response);
		} else if (acao.equals("login")) {
			LoginForm loginForm = new LoginForm();
			nomeJSP = loginForm.executa();
		} else if (acao.equals("acessarUsuario")) {
			Login login = new Login();
			nomeJSP = login.executa(request, response);
		} else if (acao.equals("logout")) {
			Logout logout = new Logout();
			nomeJSP = logout.executa(request, response);
		}

		String[] tipoEndereco = nomeJSP.split(":");
		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
	}
}