package br.com.clinicavital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotBlank(message = "Insira seu nome")
	private String nome;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Insira seu e-mail")
	private String email;
	
	@Column(nullable = false)
	@NotBlank(message = "Insira sua senha")
	private String senha;
	
	@Column(nullable = false)
	@ManyToMany
	@JoinTable(
			name = "usuario_tem_perfis",
			joinColumns = {@JoinColumn(name = "id_usuario", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "id_perfil", referencedColumnName = "id")}
	)
	private List<Perfil> perfis;
	
	@Column
	private boolean ativo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public List<Perfil> getPerfis() {
		return perfis;
	}
	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	
	
}
