package br.com.clinicavital.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.clinicavital.model.Paciente;
import br.com.clinicavital.model.Perfil;
import br.com.clinicavital.model.PerfilTipo;
import br.com.clinicavital.model.Usuario;
import br.com.clinicavital.repositry.PacienteReporitory;
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
		pacienteService.salvarPaciente(paciente);
		usuario.addPerfil(PerfilTipo.PACIENTE);
		usuarioService.salvarUsuario(usuario);
		return "paciente/cadastrar";
	}
}
