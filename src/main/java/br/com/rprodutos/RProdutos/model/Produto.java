package br.com.rprodutos.RProdutos.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	private Integer totalAvaliacao = 0;
	private Integer contadorAvaliacao = 0;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "favoritos")
	@JsonIgnore
	private List<Usuario> favoritos = new ArrayList<>();
	
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
	
	public void gerarAvaliacao(Integer avaliacao) {
		this.contadorAvaliacao ++;
		this.totalAvaliacao += avaliacao;
		Double media = (double) (this.totalAvaliacao / this.contadorAvaliacao);
		this.avaliacao = (int) Math.round(media);
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
	
	public Integer getTotalAvaliacoes() {
		return contadorAvaliacao;
	}

	public void setTotalAvaliacoes(Integer totalAvaliacoes) {
		this.contadorAvaliacao = totalAvaliacoes;
	}
	
	public Integer getContadorAvaliacao() {
		return contadorAvaliacao;
	}

	public void setContadorAvaliacao(Integer contadorAvaliacao) {
		this.contadorAvaliacao = contadorAvaliacao;
	}

	public Integer getTotalAvaliacao() {
		return totalAvaliacao;
	}

	public void setTotalAvaliacao(Integer totalAvaliacao) {
		this.totalAvaliacao = totalAvaliacao;
	}

}
