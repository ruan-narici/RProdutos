package br.com.rprodutos.RProdutos.dto;

import java.math.BigDecimal;

public class NovoProdutoDTO {

	private String nome;
	private String categoria;
	private String urlPrimeiraImagem;
	private String urlSegundaImagem;
	private String urlTerceiraImagem;
	private BigDecimal valor;
	private Integer avaliacao = 0;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getUrlPrimeiraImagem() {
		return urlPrimeiraImagem;
	}

	public void setUrlPrimeiraImagem(String urlPrimeiraImagem) {
		this.urlPrimeiraImagem = urlPrimeiraImagem;
	}

	public String getUrlSegundaImagem() {
		return urlSegundaImagem;
	}

	public void setUrlSegundaImagem(String urlSegundaImagem) {
		this.urlSegundaImagem = urlSegundaImagem;
	}

	public String getUrlTerceiraImagem() {
		return urlTerceiraImagem;
	}

	public void setUrlTerceiraImagem(String urlTerceiraImagem) {
		this.urlTerceiraImagem = urlTerceiraImagem;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

}
