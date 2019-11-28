package br.com.clinicavital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	// login inválido
	@GetMapping("/login-error")
	public String loginError(ModelMap model) {
		model.addAttribute("alerta", "erro");
		model.addAttribute("titulo", "Credenciais Inválidas");
		model.addAttribute("texto", "Login ou Senha incorretos. Tente novamente!");
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
	@GetMapping("/nutricionista")
	public String cadastrarNutricionista() {
		return "nutricionista/cadastrar";
	}
	@GetMapping("/Teste")
	public String teste() {
		return "teste";
	}
	
	
}
