package br.com.clinicavital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.clinicavital.model.Usuario;
import br.com.clinicavital.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService useService;
	
	@GetMapping("/liberar/acesso")
	public String abrirPagLiberarAcesso() {
		return "admin/liberar-acesso"; 
	}
	
	@PostMapping("/liberar/acesso/salvar")
	public String liberarAcesso(Usuario usuario){
		usuario.setAtivo(true);
		useService.salvarUsuario(usuario);
		return "admin/liberar-acesso";
	}
}
