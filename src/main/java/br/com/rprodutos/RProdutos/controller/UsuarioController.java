package br.com.rprodutos.RProdutos.controller;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rprodutos.RProdutos.dto.UsuarioDTO;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	DataSource dataSource;

	@PostMapping("/novo")
	public ResponseEntity<UserDetails> cadastrar(UsuarioDTO usuarioDto) {
//		Criando um usuario e preenchendo seus atributos
		UserDetails user = User.builder()
			.username(usuarioDto.getUsername())
			//Nesse momento e feito a criptografia da senha
			.password(usuarioDto.getPassword())
			.roles("ADM")
			.build();
		//Criando uma conexao com o JDBC
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		//Salvando o usuario no banco de dados
		users.createUser(user);
		return new ResponseEntity<UserDetails>(user, HttpStatusCode.valueOf(201));
	}
}
