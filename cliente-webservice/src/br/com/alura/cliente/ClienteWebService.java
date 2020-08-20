package br.com.alura.cliente;

import org.apache.hc.client5.http.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws Exception {
		/**
		 * Fazendo uma requisição com o método post para o endereco especificado,
		 * adicionando na requisição um cabeçalho com chave e valor, executando e
		 * aguardando um conteudo do tipo String
		 */
		String conteudo = Request.post("http://localhost:8080/Gerenciador/empresas")
				.addHeader("Accept", "application/xml").execute().returnContent().asString();
		System.out.println(conteudo);
	}
}