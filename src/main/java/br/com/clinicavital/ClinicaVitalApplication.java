package br.com.clinicavital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ClinicaVitalApplication {

	
	
	public static void main(String[] args) {
		//BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		
		//System.out.println(b.encode("1234"));
		
		SpringApplication.run(ClinicaVitalApplication.class, args);
		
	}

}
