package br.com.clinicavital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaVitalApplication {

		
	public static void main(String[] args) {
		//BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		
		//System.out.println(b.encode("1234"));
		
		SpringApplication.run(ClinicaVitalApplication.class, args);
		
	}

}
