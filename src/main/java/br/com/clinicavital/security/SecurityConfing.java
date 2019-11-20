package br.com.clinicavital.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.clinicavital.service.UsuarioService;

@EnableWebSecurity
public class SecurityConfing extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsuarioService service;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			//acessos públicos
		.antMatchers("/webjars/**").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/nutricionista/**").permitAll()
		.antMatchers("/paciente/**").permitAll()
		.anyRequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/", true)
			.failureUrl("/pagina-de-erro")
			.permitAll()
		.and()
			.logout()
			.logoutSuccessUrl("/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
}
