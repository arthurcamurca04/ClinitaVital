package br.com.clinicavital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.clinicavital.model.Nutricionista;
import br.com.clinicavital.model.Paciente;

@Controller

public class HomeController {
	
	
	@GetMapping("/")
	public String admin() {
		return "home";
	}
	
	@GetMapping("/login")
	public String home() {
		return "login";
	}
		
	@GetMapping("/paciente")
	public String abrirPagCadastro(Paciente paciente) {
		return "paciente/cadastrar";
	}

	
	
	@GetMapping("/portal")
	public String abrirPortal() {
		return "admin/portal-admin";
	}
	
	@GetMapping("/liberar")
	public String liberarAcesso() {
		return "admin/liberar-acesso";
	}
	
	@GetMapping("/acessonegado")
	public String acessonegado() {
		return "acesso-negado";
	}
	@GetMapping("/pagina-de-erro")
	public String paginaDeErro() {
		return "pagina-de-erro";
	}
	@GetMapping("/cadastrar-nutricionista")
	public String cadastrarNutricionista(Nutricionista nutricionista) {
		return "nutricionista/cadastrar-nutricionista";
	}
	@GetMapping("/Teste")
	public String teste() {
		return "teste";
	}
	
	
}
