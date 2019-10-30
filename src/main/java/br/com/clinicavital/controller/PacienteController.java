package br.com.clinicavital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.clinicavital.model.Paciente;
import br.com.clinicavital.repositry.PacienteReporitory;

@Controller
@RequestMapping("paciente")
public class PacienteController {

	//injeção de dependência de paciente repository
	@Autowired
	private PacienteReporitory reporitory;
	
	//método para cadastro de paciente
	@PostMapping("/cadastrar")
	public ModelAndView cadastrarPaciente(Paciente paciente) {
		ModelAndView mv = new ModelAndView();
		mv.addObject(reporitory.save(paciente));
		mv.setViewName("paciente/cadastrar");
		return mv;
	}
}
