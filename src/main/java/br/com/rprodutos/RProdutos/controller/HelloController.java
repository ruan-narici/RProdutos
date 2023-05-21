package br.com.rprodutos.RProdutos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public ModelAndView hello() {
		return new ModelAndView("/view/hello");
	}
}
