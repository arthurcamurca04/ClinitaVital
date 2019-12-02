package br.com.clinicavital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clinicavital.model.Paciente;
import br.com.clinicavital.model.PerfilTipo;
import br.com.clinicavital.model.Usuario;
import br.com.clinicavital.service.PacienteService;
import br.com.clinicavital.service.UsuarioService;

@Controller
@RequestMapping("paciente")
public class PacienteController {

	//injeção de dependência de paciente repository
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private UsuarioService usuarioService;
	
	//método para cadastro de paciente
	@PostMapping("/cadastrar")
	public String cadastrarPaciente( Paciente paciente) {	
		Usuario usuario = paciente.getUsuario();
		usuario.setAtivo(true);
		usuario.addPerfil(PerfilTipo.PACIENTE);
		usuarioService.salvarUsuario(usuario);
		pacienteService.salvarPaciente(paciente);
		return "paciente/cadastrar";
	}
	
	//método para agendar consultas
	@GetMapping("/agendamentos/agendar")
	public String agendarConsulta() {
		return "paciente/agendar-consulta";
	}
}
