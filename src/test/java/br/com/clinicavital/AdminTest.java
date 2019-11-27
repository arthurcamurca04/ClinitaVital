package br.com.clinicavital;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.clinicavital.model.Usuario;
import br.com.clinicavital.service.UsuarioService;

@SpringBootTest
public class AdminTest {

	@Autowired
	private static UsuarioService service;
	
//	@Test
//	public List<Usuario> listarUsuarios(){
//		return service.listarUsers();
//	}
	
	public static void test() {
		List<Usuario> lista = service.listarUsers();
		for(Usuario u:lista) {
			System.out.println(u);
		}
	}
}
