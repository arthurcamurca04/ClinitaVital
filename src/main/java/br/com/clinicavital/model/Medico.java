package br.com.clinicavital.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String crm;
	
	@OneToOne(cascade = CascadeType.ALL)
	@Column(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "medico_tem_especialidades",
				joinColumns = @JoinColumn(name = "id_medico" , referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "id_especialidade" , referencedColumnName = "id"))
	private Set<EspecialidadesMedico> especialidades;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
