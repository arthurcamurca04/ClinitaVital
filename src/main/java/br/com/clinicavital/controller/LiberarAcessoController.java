package br.com.clinicavital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LiberarAcessoController {

	@GetMapping("/admin/liberar-acesso")
	public String retornar() {
		return "admin/liberar-acesso";
	}
}
