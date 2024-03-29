package br.com.clinicavital.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "especialidades", indexes = {@Index(name = "idx_especialidade_titulo", columnList = "titulo")})
public class Especialidade{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo", unique = true, nullable = false)
	private String titulo;
	
	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;
	
	@ManyToMany
	@JoinTable(
			name = "medicos_tem_especialidades",
			joinColumns = @JoinColumn(name = "id_especialidade", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "id_medico", referencedColumnName = "id")
    )
	private List<Medico> medicos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedico(List<Medico> medicos) {
		this.medicos = medicos;
	}
}
