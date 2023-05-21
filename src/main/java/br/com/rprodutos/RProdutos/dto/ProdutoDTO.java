package br.com.rprodutos.RProdutos.dto;

import java.math.BigDecimal;

import br.com.rprodutos.RProdutos.model.Produto;

public class ProdutoDTO {
	
	private String nome;
	private String urlImagem;
	private BigDecimal valor;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Produto toProduto() {
		Produto produto = new Produto();
		produto.setNome(this.nome);
		produto.setValor(this.valor);
		produto.setUrlImagem(this.urlImagem);
		return produto;
	}
	
}
