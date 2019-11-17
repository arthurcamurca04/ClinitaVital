package br.com.clinicavital.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.clinicavital.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("select u from Usuario u where u.email like :email")
	Usuario getPorEmail(@Param("email") String email);
}
