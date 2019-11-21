package br.com.clinicavital.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clinicavital.model.Perfil;
import br.com.clinicavital.model.Usuario;
import br.com.clinicavital.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService useService;
	
	@GetMapping("/liberar/acesso")
	public String abrirPagLiberarAcesso(Usuario usuario) {
		return "admin/liberar-acesso"; 
	}
	
	@PostMapping("/admin/liberar/acesso")
	public String liberarAcesso(Usuario usuario){
		List<Perfil> perfis = usuario.getPerfis();
		if (perfis.size() > 2 || perfis.containsAll(Arrays.asList(new Perfil(1L), new Perfil(3L)))
				|| perfis.containsAll(Arrays.asList(new Perfil(2L), new Perfil(3L)))) {
		} else {

			try {
				useService.salvarUsuario(usuario);
			} catch (DataIntegrityViolationException e) {
				throw new DataIntegrityViolationException("Não foi possivél liberar acesso");
			}
		}
		return "admin/liberar-acesso";
	}
}
