package br.com.rprodutos.RProdutos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/entrar")
public class EntrarController {

	@GetMapping
	public ModelAndView entrar() {
		return new ModelAndView("view/usuario/entrar");
	}
}