package br.com.rprodutos.RProdutos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/inicio")
public class InicioController {

	@GetMapping
	public ModelAndView inicio() {
		return new ModelAndView("view/index");
	}
}
