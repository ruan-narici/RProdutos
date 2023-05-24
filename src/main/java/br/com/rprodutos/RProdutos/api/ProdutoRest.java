package br.com.rprodutos.RProdutos.api;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		produtos.sort((o1, o2) -> o1.getCategoria().toString().compareTo(o2.getCategoria().toString()));
		return new ResponseEntity<List<Produto>>(produtos, HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/recentes")
	public ResponseEntity<List<Produto>> novos() {
		List<Produto> produtos = produtoService.listarNovos();
		return new ResponseEntity<List<Produto>>(produtos, HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/avaliacoes")
	public ResponseEntity<List<Produto>> melhoresAvaliacoes() {
		List<Produto> produtos = produtoService.listarMelhoresAvaliados();
		return new ResponseEntity<List<Produto>>(produtos, HttpStatusCode.valueOf(200));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Produto> cadastrar(@RequestBody NovoProdutoDTO novoProdutoDTO, Principal principal) {
		Produto produto = produtoService.cadastrar(novoProdutoDTO, principal);
		return new ResponseEntity<Produto>(produto, HttpStatusCode.valueOf(201));
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable(name = "id") String id, @RequestBody NovoProdutoDTO novoProdutoDTO) {
		Produto produto = produtoService.editar(Long.parseLong(id), novoProdutoDTO);
		return new ResponseEntity<Produto>(produto, HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<HttpStatusCode> excluir(@PathVariable(name = "id") String id) {
		produtoService.excluir(Long.parseLong(id));
		return new ResponseEntity<HttpStatusCode>(HttpStatusCode.valueOf(204));
	}
	
	@PutMapping("/avaliar/{id}/{avaliacao}")
	public ResponseEntity<Produto> avaliar(@PathVariable(name = "id") Long id, @PathVariable(name = "avaliacao") Integer avaliacao) {
		Produto produto = produtoService.avaliar(id, avaliacao);
		return new ResponseEntity<Produto>(produto, HttpStatusCode.valueOf(201));
	}

}
