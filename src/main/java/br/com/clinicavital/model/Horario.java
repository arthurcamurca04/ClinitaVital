package br.com.clinicavital.model;

import java.time.LocalTime;

import javax.persistence.*;

@Entity
@Table(name = "horas", indexes = {@Index(name = "idx_hora_minuto", columnList = "hora_minuto")})
public class Horario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "hora_minuto", unique = true, nullable = false)
	private LocalTime horaMinuto;

	public LocalTime getHoraMinuto() {
		return horaMinuto;
	}

	public void setHoraMinuto(LocalTime horaMinuto) {
		this.horaMinuto = horaMinuto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
