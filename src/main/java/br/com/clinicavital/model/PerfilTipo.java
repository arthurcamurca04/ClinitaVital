package br.com.clinicavital.model;

public enum PerfilTipo {

	ADMIN(1, "ADMIN"), MEDICO(2, "MEDICO"), PACIENTE(3, "PACIENTE"), 
		FISIOTERAPEUTA(4, "FISIOTERAPEUTA"), NUTRICIONISTA(5, "NUTRICIONISTA");

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
