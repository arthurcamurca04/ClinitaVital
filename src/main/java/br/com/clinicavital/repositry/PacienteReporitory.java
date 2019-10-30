package br.com.clinicavital.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinicavital.model.Paciente;

public interface PacienteReporitory extends JpaRepository<Paciente, Long>{

}
