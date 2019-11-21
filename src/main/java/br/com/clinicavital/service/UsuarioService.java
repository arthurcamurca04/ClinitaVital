package br.com.clinicavital.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinicavital.model.Perfil;
import br.com.clinicavital.model.Usuario;
import br.com.clinicavital.repositry.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Transactional( readOnly = true )
	public Usuario obterPorEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Transactional( readOnly = true )
	public List<Usuario> listarUsers() {
		return userRepository.findAll();
	}
	
	private String[] getAuthorities(List<Perfil> perfis) {
		String[] authorities = new String[perfis.size()];
		for(int i=0; i<perfis.size(); i++) {
			authorities[i] = perfis.get(i).getDesc();
		}
		return authorities;
	}


	@Override
	@Transactional( readOnly = true )
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario u = obterPorEmail(username);
		if(u==null) {
			System.out.println("Não existe usuário");
		}
		return new User(
				u.getEmail(),
				u.getSenha(),
				AuthorityUtils.createAuthorityList(getAuthorities(u.getPerfis()))
				);
	}

	public void salvarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		userRepository.save(usuario);
		
	}
	
	
}
