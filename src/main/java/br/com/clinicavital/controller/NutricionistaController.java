package br.com.clinicavital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.clinicavital.model.Nutricionista;
import br.com.clinicavital.repository.NutricionistaRepository;

@Controller
@RequestMapping("nutricionista")
public class NutricionistaController {

		
	@Autowired
	private NutricionistaRepository repository;
	
	//metodo cadastrar
	@PostMapping("/cadastrar-nutricionista")
	public ModelAndView cadastrarNutricionista(Nutricionista nutricionista) {
		ModelAndView mv = new ModelAndView();
		mv.addObject(repository.save(nutricionista));
		mv.setViewName("nutricionista/cadastrar-nutricionista");
		return mv;
	}
}
