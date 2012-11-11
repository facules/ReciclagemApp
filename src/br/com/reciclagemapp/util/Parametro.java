package br.com.reciclagemapp.util;

import org.apache.http.NameValuePair;

public class Parametro implements NameValuePair{
	
	private String nome;
	
	private String valor;
	
	public Parametro(String nome, String valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getName() {
		return nome;
	}

	public String getValue() {
		return valor;
	}

}
