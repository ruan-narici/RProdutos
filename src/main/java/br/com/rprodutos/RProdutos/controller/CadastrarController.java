package br.com.rprodutos.RProdutos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cadastrar")
public class CadastrarController {

	@GetMapping
	public ModelAndView cadastrar() {
		return new ModelAndView("view/usuario/cadastrar");
	}
}
