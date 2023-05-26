package br.com.rprodutos.RProdutos.api;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rprodutos.RProdutos.dto.NovoUsuarioDTO;
import br.com.rprodutos.RProdutos.model.Produto;
import br.com.rprodutos.RProdutos.model.Usuario;
import br.com.rprodutos.RProdutos.service.ProdutoService;
import br.com.rprodutos.RProdutos.service.UsuarioService;
import jakarta.persistence.Entity;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRest {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProdutoService produtoService;
	

	@PostMapping("/cadastrar")
	public ResponseEntity<NovoUsuarioDTO> salvarCadastro(@RequestBody NovoUsuarioDTO novoUsuarioDto) {
		usuarioService.cadastrar(novoUsuarioDto, "ADM");
		return new ResponseEntity<NovoUsuarioDTO>(novoUsuarioDto, HttpStatusCode.valueOf(201));
	}
	
	@GetMapping("/meus-produtos")
	public ResponseEntity<List<Produto>> listarProdutos(Principal principal) {
		List<Produto> produtos = produtoService.listarPorUsuario(principal);
		produtos.sort((o1, o2) -> o2.getId().compareTo(o1.getId()));
		return new ResponseEntity<List<Produto>>(produtos, HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/favoritar/{idProduto}")
	public ResponseEntity<List<Produto>> adicionarFavorito(@PathVariable(name = "idProduto") String idProduto, Principal principal) {
		List<Produto> favoritos = usuarioService.adicionarFavorito(principal, Long.parseLong(idProduto));
		return new ResponseEntity<List<Produto>>(favoritos, HttpStatusCode.valueOf(201));
	}
	
	@PostMapping("/desfavoritar/{idProduto}")
	public ResponseEntity<HttpStatusCode> removerFavorito(@PathVariable(name = "idProduto") String idProduto, Principal principal) {
		usuarioService.removerFavorito(principal, Long.parseLong(idProduto));
		return new ResponseEntity<HttpStatusCode>(HttpStatusCode.valueOf(201));
	}
	
	@GetMapping("/favoritos")
	public ResponseEntity<List<Produto>> getUsuario(Principal principal) {
		Usuario usuario = usuarioService.buscarPorId(principal.getName());
		List<Produto> produtos = usuario.getFavoritos();
		return new ResponseEntity<List<Produto>>(produtos, HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/owner")
	public ResponseEntity<Usuario> getUsuarioLogado(Principal principal) {
		Usuario usuario = usuarioService.getUsuarioLogado(principal);
		return new ResponseEntity<Usuario>(usuario, HttpStatusCode.valueOf(200));
	}
}
