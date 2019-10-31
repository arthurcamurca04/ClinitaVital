package br.com.clinicavital;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.clinicavital.model.Endereco;
import br.com.clinicavital.model.Paciente;
import br.com.clinicavital.model.Usuario;
import br.com.clinicavital.repositry.PacienteReporitory;

@SpringBootTest
class ClinicaVitalApplicationTests {

	@Autowired
	private PacienteReporitory rep;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void inserirPaciente() {
		Usuario user = new Usuario();
		Paciente paciente = new Paciente();
		Endereco end = new Endereco();
		
		user.setNome("André");
		user.setAtivo(true);
		user.setEmail("andre@test.com");
		user.setSenha("1234");
		
		end.setBairro("Salgadiho");
		end.setCep("58796000");
		end.setCidade("Patos");
		end.setEstado("PB");
		end.setRua("Rua projetada");
		
		paciente.setUsuario(user);
		paciente.setCpf("12345678911");
		paciente.setTelefone("933335566");
		paciente.setEndereco(end);
		
		rep.save(paciente);
	}
	
	//@Test
	public void alterarPaciente() {
		Paciente paciente = rep.findById(3L).get();
		paciente.getUsuario().setNome("Carlos Reinaldo");
		paciente.getEndereco().setCidade("Piancó");
		rep.save(paciente);
	}
	
	//@Test
	public void excluir() {
		Paciente paciente = rep.findById(3L).get();
		rep.delete(paciente);
	}	
}
