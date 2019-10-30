package br.com.clinicavital.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime horario;
	
	@ManyToOne
	@Column(name = "id_paciente")
	private Paciente paciente;
	
	@Column
	@NotBlank(message = "Insira o profiissional")
	private String profissional;
	
	@Column
	private String identificador_profissional;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getProfissional() {
		return profissional;
	}

	public void setProfissional(String profissional) {
		this.profissional = profissional;
	}

	public String getIdentificador_profissional() {
		return identificador_profissional;
	}

	public void setIdentificador_profissional(String identificador_profissional) {
		this.identificador_profissional = identificador_profissional;
	}
	
	
}
