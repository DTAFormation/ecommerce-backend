package dta.commerce.persistance;

public class Mail {
	private String expediteur;
	private String msg;
	private String object;
	
	
	
	public Mail() {
		super();
	
	}
	public Mail(String expediteur, String msg, String object) {
		super();
		this.expediteur = expediteur;
		this.msg = msg;
		this.object = object;
	}
	public String getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	
	
	

}
