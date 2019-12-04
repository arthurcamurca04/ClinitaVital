package br.com.clinicavital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinicavital.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {
	
	@Autowired
	private EspecialidadeRepository repository;

	@Transactional(readOnly = true)
	public List<String> buscarEspecialidadesPorTermo(String termo){
		return repository.findEspecialidadesByTermo(termo);
	}
}
