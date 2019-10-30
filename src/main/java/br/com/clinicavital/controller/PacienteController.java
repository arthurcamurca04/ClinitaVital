package br.com.clinicavital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {

	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "paciente/cadastrar";
	}
}
