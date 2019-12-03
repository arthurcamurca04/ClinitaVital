package br.com.clinicavital.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import br.com.clinicavital.model.Agendamento;
import br.com.clinicavital.model.Paciente;
import br.com.clinicavital.model.Perfil;
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
	public String cadastrarPaciente(Paciente paciente,
			ModelMap attr) {
		
		Usuario usuario = paciente.getUsuario();
		usuario.setAtivo(true);
		usuario.addPerfil(PerfilTipo.PACIENTE);
		usuarioService.salvarUsuario(usuario);
		pacienteService.salvarPaciente(paciente);
		attr.addAttribute("sucesso", "Cadastro realizado com sucesso");		
		return "paciente/cadastrar";
	}
	

	/*//método para agendar consultas
	@GetMapping("/agendamentos/agendar")
	public String agendarConsulta() {
		return "paciente/agendar-consulta";
	}*/
	
}
