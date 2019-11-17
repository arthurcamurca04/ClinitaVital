package br.com.clinicavital.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfing extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			//acessos públicos
		.antMatchers("/webjars/**").permitAll()
		.antMatchers("/**", "/home").permitAll()
		.antMatchers("/nutricionista/**").permitAll()
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
}
