package br.com.rprodutos.RProdutos.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Usuario {

	@Id
	private String username;
	private String password;
	private Boolean enabled;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Produto> favoritos = new ArrayList<>();

	public List<Produto> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Produto> favoritos) {
		this.favoritos = favoritos;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
