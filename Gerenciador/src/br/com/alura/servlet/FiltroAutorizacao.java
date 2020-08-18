package br.com.alura.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/entrada")
public class FiltroAutorizacao implements Filter {

	/**
	 * Nas novas versões do TomCat não é necessário implementar os métodos "init" e
	 * "destroy", pois ele já possui uma implementação padrão
	 */

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String acao = request.getParameter("acao");

		HttpSession sessao = request.getSession();
		boolean usuarioLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean acaoPrincipal = !(acao.equals("login") || acao.equals("acessarUsuario"));

		if (usuarioLogado && acaoPrincipal) {
			response.sendRedirect("entrada?acao=login");
			return;
		}

		chain.doFilter(request, response);
	}
}