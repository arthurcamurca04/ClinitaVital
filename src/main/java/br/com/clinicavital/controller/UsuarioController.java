package br.com.clinicavital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.clinicavital.model.Usuario;
import br.com.clinicavital.repositry.UsuarioRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/liberar/acesso")
	public String abrirPagLiberarAcesso() {
		return "admin/liberar-acesso"; 
	}
	
	@PostMapping("/liberar/acesso/salvar")
	public String liberarAcesso(Usuario usuario){
		repository.save(usuario);
		return "redirect:/liberar/acesso";
	}
}
