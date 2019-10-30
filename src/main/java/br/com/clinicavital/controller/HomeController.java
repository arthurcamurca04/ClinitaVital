package br.com.clinicavital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.clinicavital.model.Paciente;

@Controller

public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/paciente")
	public String abrirPagCadastro(Paciente paciente) {
		return "paciente/cadastrar";
	}

}
