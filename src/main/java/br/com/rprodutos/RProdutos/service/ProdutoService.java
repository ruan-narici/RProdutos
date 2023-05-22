package br.com.rprodutos.RProdutos.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rprodutos.RProdutos.dto.NovoProdutoDTO;
import br.com.rprodutos.RProdutos.model.Categoria;
import br.com.rprodutos.RProdutos.model.Produto;
import br.com.rprodutos.RProdutos.repository.ProdutoRepository;
import br.com.rprodutos.RProdutos.repository.UsuarioRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public Produto cadastrar(NovoProdutoDTO novoProdutoDTO, Principal principal) {
		Produto produto = new Produto();
		produto.setNome(novoProdutoDTO.getNome());
		produto.setCategoria(Categoria.valueOf(novoProdutoDTO.getCategoria()));
		produto.setValor(novoProdutoDTO.getValor());
		produto.setUrlPrimeiraImagem(novoProdutoDTO.getUrlPrimeiraImagem());
		produto.setUrlSegundaImagem(novoProdutoDTO.getUrlSegundaImagem());
		produto.setUrlTerceiraImagem(novoProdutoDTO.getUrlTerceiraImagem());
		produto.setAvaliacao(novoProdutoDTO.getAvaliacao());
		
		produto.setUsuario(usuarioRepository.findById(principal.getName()).get());
//		produto.setUsuario(null);
		
		produtoRepository.save(produto);
		return produto;
	}

	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}
}
