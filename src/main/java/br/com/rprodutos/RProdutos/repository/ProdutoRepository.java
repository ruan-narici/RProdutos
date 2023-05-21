package br.com.rprodutos.RProdutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rprodutos.RProdutos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
