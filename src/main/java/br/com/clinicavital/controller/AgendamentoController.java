package br.com.clinicavital.controller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import br.com.clinicavital.model.Agendamento;
import br.com.clinicavital.model.Paciente;
import br.com.clinicavital.model.Usuario;
import br.com.clinicavital.service.AgendamentoService;
import br.com.clinicavital.service.PacienteService;


@Controller
@RequestMapping("agendamentos")
public class AgendamentoController {

	@Autowired
	AgendamentoService agendamentoService;
	
	@Autowired
	PacienteService pacienteService;

	
	@GetMapping("/agendar")
	public String abrirPaginaAgendamento(Agendamento agendamento) {
		return "agendamento/agendar-consulta";
	}
	
	
	//método ao ser submetido o agendamento
	@PostMapping("/agendar/salvar")
	public String agendarConsultaMedica(Agendamento agendamento){
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Usuario userLogado = (Usuario) authentication;
			Paciente pacienteLogado = pacienteService.buscarPorUsuarioEmail(userLogado.getEmail());
			agendamento.setPaciente(pacienteLogado);
			agendamentoService.salvarAgendamento(agendamento);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possivel salvar o agendamento");
		}
		return "agendamento/agendar-consulta";
	}
}
