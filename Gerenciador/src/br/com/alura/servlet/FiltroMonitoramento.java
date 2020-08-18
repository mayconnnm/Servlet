package br.com.alura.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter("/entrada")
public class FiltroMonitoramento implements Filter {

	int total = 1;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long inicio = System.currentTimeMillis();
		chain.doFilter(request, response);
		long fim = System.currentTimeMillis();

		System.out.println("Tempo: " + (fim - inicio) + " Requisição: " + total);
		total++;
	}
}