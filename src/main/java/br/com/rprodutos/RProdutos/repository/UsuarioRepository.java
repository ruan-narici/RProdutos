package br.com.rprodutos.RProdutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rprodutos.RProdutos.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
