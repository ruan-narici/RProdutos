package br.com.rprodutos.RProdutos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class PrincipalController {

	@GetMapping("/principal")
	public ModelAndView principalPadrao() {
		return new ModelAndView("view/produto/listaProduto");
	}
	
	@GetMapping("/recentes")
	public ModelAndView principalRecentes() {
		return new ModelAndView("view/produto/listaProdutoRecente");
	}
	
	@GetMapping("/avaliacoes")
	public ModelAndView principalAvaliacoes() {
		return new ModelAndView("view/produto/listaProdutoAvaliacao");
	}
}
