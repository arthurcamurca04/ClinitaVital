package br.com.clinicavital.model;

public enum SiglasEstados {
/*Siglas estados*/
		AC(1,"AC"),
		AL(2,"AL"),
		AP(3,"Ap"),
		AM(4,"AM"),
		BA(5,"BA"),
		CE(6,"CE"),
		DF(7,"DF"),
		ES(8,"ES"),
		GO(9,"GO"),
		MA(10,"MA"),
		MT(11,"MT"),
		MS(12,"MS"),
		MG(13,"MG"),
		PA(14,"PA"),
		PB(15,"PB"),
		PR(16,"PR"),
		PE(17,"PE"),
		PI(18,"PI"),
		RR(19,"RR"),
		RO(20,"RO"),
		RJ(21,"RJ"),
		RN(22,"RN"),
		RS(23,"RS"),
		SC(24,"SC"),
		SP(25,"SP"),
		SE(26,"SE"),
		TO(27,"TO");
	
	private long cod;
	private String desc;
	
	private SiglasEstados(long cod, String desc) {
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
