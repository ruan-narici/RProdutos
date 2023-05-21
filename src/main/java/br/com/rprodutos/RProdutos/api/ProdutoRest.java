package br.com.rprodutos.RProdutos.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rprodutos.RProdutos.model.Produto;
import br.com.rprodutos.RProdutos.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produto")
public class ProdutoRest {
	
	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/todos")
	public ResponseEntity<List<Produto>> getProdutos() {
		List<Produto> produtos = produtoRepository.findAll();
		return new ResponseEntity<List<Produto>>(produtos, HttpStatusCode.valueOf(200));
	}
	
}
