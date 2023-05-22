package br.com.rprodutos.RProdutos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		return new ModelAndView("view/produto/novoProduto");
	}

}
