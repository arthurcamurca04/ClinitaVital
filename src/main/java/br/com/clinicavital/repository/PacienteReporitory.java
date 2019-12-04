package br.com.clinicavital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.clinicavital.model.Paciente;

public interface PacienteReporitory extends JpaRepository<Paciente, Long>{

	@Query("select p from Paciente p where p.usuario.email like :email")
	Paciente findByEmail(@Param("email") String email);
}
