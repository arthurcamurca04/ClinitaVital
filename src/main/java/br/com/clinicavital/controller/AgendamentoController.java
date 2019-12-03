package br.com.clinicavital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clinicavital.model.Agendamento;
import br.com.clinicavital.service.AgendamentoService;

@Controller
@RequestMapping("agendamentos")
public class AgendamentoController {

	@Autowired
	AgendamentoService agendamentoService;
	
	@GetMapping("/agendar")
	public String abrirPaginaAgendamento(Agendamento agendamento) {
		return "agendamento/agendar-consulta";
	}
	
	
	//método ao ser submetido o agendamento
	@PostMapping("/agendar/salvar")
	public String agendarConsultaMedica(Agendamento agendamento){
		try {
			agendamentoService.salvarAgendamento(agendamento);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possivel salvar o agendamento");
		}
		return "agendamento/agendar-consulta";
	}
}
