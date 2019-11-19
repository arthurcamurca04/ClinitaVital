package br.com.clinicavital.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "fisioterapeutas")
public class Fisioterapeuta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", unique = true, nullable = false)
	private String nome;
	
	@Column(name = "crefito", unique = true, nullable = false)
	private Integer crefito;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_inscricao", nullable = false)
	private LocalDate dtInscricao;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Fisioterapeuta() {
		super();
	}

	public Fisioterapeuta(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCrefito() {
		return crefito;
	}

	public void setCrefito(Integer crefito) {
		this.crefito = crefito;
	}

	public LocalDate getDtInscricao() {
		return dtInscricao;
	}

	public void setDtInscricao(LocalDate dtInscricao) {
		this.dtInscricao = dtInscricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
}
