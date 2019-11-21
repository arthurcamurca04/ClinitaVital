package br.com.clinicavital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.clinicavital.model.Paciente;
import br.com.clinicavital.repositry.PacienteReporitory;
import br.com.clinicavital.service.PacienteService;

@Controller
@RequestMapping("paciente")
public class PacienteController {

	//injeção de dependência de paciente repository
	@Autowired
	private PacienteService service;
	
	//método para cadastro de paciente
	@PostMapping("/cadastrar")
	public String cadastrarPaciente(Paciente paciente) {		
		service.salvarPaciente(paciente);
		return "paciente/cadastrar";
	}
}
