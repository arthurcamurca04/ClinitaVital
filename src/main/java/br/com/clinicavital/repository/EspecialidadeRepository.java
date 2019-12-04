package br.com.clinicavital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.clinicavital.model.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long>{
	
	@Query("select e.titulo from Especialidade e where e.titulo like :termo%")
	List<String> findEspecialidadesByTermo(String termo);
}
