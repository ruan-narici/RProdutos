package br.com.rprodutos.RProdutos.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		Sort sort = Sort.by("categoria").descending();
		
		PageRequest page = PageRequest.of(0, 10, sort);
		
		return produtoRepository.findByPage(page);
	}
	
	public List<Produto> listarNovos() {
		Sort sort = Sort.by("id").descending();
		
		PageRequest page = PageRequest.of(0, 5, sort);
		
		return produtoRepository.findByPage(page);
	}
	
	public List<Produto> listarPorUsuario(Principal usuario) {
		return produtoRepository.findByUsuario(usuario.getName());
	}
	
	public void excluir(Long id) {
		produtoRepository.deleteById(id);
	}
}
