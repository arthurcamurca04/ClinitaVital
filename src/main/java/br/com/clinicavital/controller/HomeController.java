package br.com.clinicavital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.clinicavital.model.Paciente;

@Controller

public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "login";
	}
	
	@GetMapping("/paciente")
	public String abrirPagCadastro(Paciente paciente) {
		return "paciente/cadastrar";
	}

	@GetMapping("/portal")
	public String abrirPortal() {
		return "portal";
	}
	@GetMapping("/acessonegado")
	public String acessonegado() {
		return "acesso-negado";
	}
	@GetMapping("/pagina-de-erro")
	public String paginaDeErro() {
		return "pagina-de-erro";
	}
	@GetMapping("/Teste")
	public String teste() {
		return "teste";
	}
	
	
}
