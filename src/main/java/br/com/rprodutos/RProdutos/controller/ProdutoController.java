package br.com.rprodutos.RProdutos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.rprodutos.RProdutos.dto.ProdutoDTO;
import br.com.rprodutos.RProdutos.model.Produto;
import br.com.rprodutos.RProdutos.repository.ProdutoRepository;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@PostMapping("/novo")
	public ResponseEntity<Produto> newProduto(ProdutoDTO produtoDto) {
		Produto produto = produtoDto.toProduto();
		produtoRepository.save(produto);
		return new ResponseEntity<Produto>(produto, HttpStatusCode.valueOf(201));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Produto> updProduto(Produto produto) {
		Produto produtoNovo = produtoRepository.findById(produto.getId()).get();
		produtoNovo.setNome(produto.getNome());
		produtoNovo.setUrlImagem(produto.getUrlImagem());
		produtoNovo.setValor(produto.getValor());
		produtoNovo.setAvaliacao(produto.getAvaliacao());
		
		produtoRepository.save(produtoNovo);
		return new ResponseEntity<Produto>(produtoNovo, HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Produto> deleteProduto(@PathVariable String id) {
		Produto produto = produtoRepository.findById(Long.parseLong(id)).get();
		produtoRepository.deleteById(Long.parseLong(id));
		return new ResponseEntity<Produto>(produto, HttpStatusCode.valueOf(200));
	}
}
