package br.com.clinicavital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.clinicavital.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

	@Query("select a from Agendamento a where a.paciente like :id")
	Agendamento findByPaciente(@Param("id") Long id);
	
	@Query("select a from Agendamento a where a.medico like :id")
	Agendamento findByMedico(@Param("id") Long id);
	
}
