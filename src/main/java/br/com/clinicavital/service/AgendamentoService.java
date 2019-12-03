package br.com.clinicavital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinicavital.model.Agendamento;
import br.com.clinicavital.repositry.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repository;
	
	@Transactional(readOnly = false)
	public void salvarAgendamento(Agendamento agendamento) {
		repository.save(agendamento);
	}
}
