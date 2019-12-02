package br.com.clinicavital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clinicavital.model.Agendamento;

@Controller
@RequestMapping("agendamentos")
public class AgendamentoController {

	@GetMapping("/agendar")
	public String abrirPaginaAgendamento(Agendamento agendamento) {
		return "agendamento/agendar-consulta";
	}
}
