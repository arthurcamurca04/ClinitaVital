package br.com.clinicavital.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinicavital.model.Paciente;
import br.com.clinicavital.repository.PacienteReporitory;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteReporitory repository;
	
	@Transactional(readOnly = false)
	public void salvarPaciente(Paciente paciente) {
		repository.save(paciente);
	}

	public Paciente buscarPorUsuarioEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
		
	}

}
