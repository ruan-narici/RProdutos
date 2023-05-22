package br.com.rprodutos.RProdutos.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import br.com.rprodutos.RProdutos.dto.NovoUsuarioDTO;

@Service
public class UsuarioService {

	@Autowired
	DataSource dataSource;

	public void cadastrar(NovoUsuarioDTO novoUsuarioDTO, String role) {
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
//			Criando um usuario e preenchendo seus atributos
		UserDetails user = User.builder().username(novoUsuarioDTO.getUsername())
				// Nesse momento e feito a criptografia da senha
				.password(encode.encode(novoUsuarioDTO.getPassword())).roles(role).build();
		// Criando uma conexao com o JDBC
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		// Salvando o usuario no banco de dados
		users.createUser(user);
	}
}
