package br.com.clinicavital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.clinicavital.model.Nutricionista;

public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {

}
