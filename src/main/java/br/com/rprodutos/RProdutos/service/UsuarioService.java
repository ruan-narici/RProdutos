package br.com.rprodutos.RProdutos.service;

import java.security.Principal;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import br.com.rprodutos.RProdutos.dto.NovoUsuarioDTO;
import br.com.rprodutos.RProdutos.model.Produto;
import br.com.rprodutos.RProdutos.model.Usuario;
import br.com.rprodutos.RProdutos.repository.ProdutoRepository;
import br.com.rprodutos.RProdutos.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;

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
	
	public List<Produto> adicionarFavorito(Principal principal, Long idProduto) {
		Usuario usuario = usuarioRepository.findById(principal.getName()).get();
		Produto produto = produtoRepository.findById(idProduto).get();
		usuario.getFavoritos().add(produto);
		usuarioRepository.save(usuario);
		return usuario.getFavoritos();
	}
	
	public void removerFavorito(Principal principal, Long idProduto) {
		Usuario usuario = usuarioRepository.findById(principal.getName()).get();
		Produto produto = produtoRepository.findById(idProduto).get();
		usuario.getFavoritos().remove(produto);
		usuarioRepository.save(usuario);
	}
	
	public Usuario buscarPorId(String id) {
		Usuario usuario = usuarioRepository.findById(id).get();
		return usuario;
	}
	
}
