package br.com.rprodutos.RProdutos.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	private String urlPrimeiraImagem;
	private String urlSegundaImagem;
	private String urlTerceiraImagem;
	private BigDecimal valor;
	private Integer avaliacao = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
