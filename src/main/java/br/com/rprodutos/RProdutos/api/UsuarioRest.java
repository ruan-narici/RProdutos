package br.com.rprodutos.RProdutos.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rprodutos.RProdutos.dto.NovoUsuarioDTO;
import br.com.rprodutos.RProdutos.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRest {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/cadastrar")
	public ResponseEntity<NovoUsuarioDTO> salvarCadastro(@RequestBody NovoUsuarioDTO novoUsuarioDto) {
		usuarioService.cadastrar(novoUsuarioDto, "ADM");
		return new ResponseEntity<NovoUsuarioDTO>(novoUsuarioDto, HttpStatusCode.valueOf(201));
	}
}
