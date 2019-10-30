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
public class Fisioterapeuta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String crefito;
	
	@OneToOne(cascade = CascadeType.ALL)
	@Column
	private Usuario usuario;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "fisioterapeuta_tem_especialidades",
				joinColumns = @JoinColumn(name = "id_fisioterapeuta" , referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "id_especialidade" , referencedColumnName = "id"))
	private Set<EspecialidadesFisioterapeuta> especialidades;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCrefito() {
		return crefito;
	}

	public void setCrefito(String crefito) {
		this.crefito = crefito;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
