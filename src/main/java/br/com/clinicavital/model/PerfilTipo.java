package br.com.clinicavital.model;

public enum PerfilTipo {
	ADMIN(1, "ADMIN"), MEDICO(2, "MEDICO"), FISIOTERAPEUTA(3, "FISIOTERAPEUTA"), 
	NUTRICIONISTA(4, "NUTRIOCIONISTA"), PACIENTE(5, "PACIENTE");
	
	private long cod;
	private String desc;

	private PerfilTipo(long cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public long getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
}
