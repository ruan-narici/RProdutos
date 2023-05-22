package br.com.rprodutos.RProdutos.api;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rprodutos.RProdutos.dto.NovoProdutoDTO;
import br.com.rprodutos.RProdutos.model.Produto;
import br.com.rprodutos.RProdutos.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoRest {

	@Autowired
	ProdutoService produtoService;

	@GetMapping("/todos")
	public ResponseEntity<List<Produto>> todos() {
		List<Produto> produtos = produtoService.listarTodos();
		return new ResponseEntity<List<Produto>>(produtos, HttpStatusCode.valueOf(200));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Produto> cadastrar(@RequestBody NovoProdutoDTO novoProdutoDTO, Principal principal) {
		Produto produto = produtoService.cadastrar(novoProdutoDTO, principal);
		return new ResponseEntity<Produto>(produto, HttpStatusCode.valueOf(201));
	}

}
