package br.com.clinicavital.model;

import javax.persistence.*;

@Entity
@Table(name = "perfis")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descricao", nullable = false, unique = true)
	private String desc;
	
	public Perfil() {
		super();
	}
	
	public Perfil(Long id) {
		setId(id);
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
