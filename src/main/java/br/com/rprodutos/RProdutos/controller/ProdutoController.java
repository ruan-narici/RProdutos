package br.com.rprodutos.RProdutos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.rprodutos.RProdutos.model.Produto;
import br.com.rprodutos.RProdutos.service.ProdutoService;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		return new ModelAndView("view/produto/novoProduto");
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable(value = "id") String id, Model model) {
		Produto produto = produtoService.buscarPorId(Long.parseLong(id));
		model.addAttribute("produto", produto);
		return new ModelAndView("view/produto/atualizarProduto");
	}

}
