package br.com.rprodutos.RProdutos.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rprodutos.RProdutos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	@Query("SELECT p FROM Produto p JOIN p.usuario u WHERE u.username = :username")
	@Cacheable("buscarUsuario")
	public List<Produto> findByUsuario(@Param(value = "username") String username);
	
	
	@Query("SELECT p FROM Produto p")
	@Cacheable("buscarPorPagina")
	public List<Produto> findByPage(Pageable page);
	
}
