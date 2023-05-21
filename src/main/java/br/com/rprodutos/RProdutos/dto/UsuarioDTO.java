package br.com.rprodutos.RProdutos.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioDTO {

	private String username;
	private String password;
	private Boolean enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		return encode.encode(this.password);
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
