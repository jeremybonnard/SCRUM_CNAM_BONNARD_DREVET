package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business;

import java.io.Serializable;

public class Status implements Serializable {
	
	
	private int idStatus;
	private String nomStatus;
	
	
	/*
	 * Getter setter
	 */
	
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	public String getNomStatus() {
		return nomStatus;
	}
	public void setNomStatus(String nomStatus) {
		this.nomStatus = nomStatus;
	}
	
	
	/*
	 * Constructeur complet
	 */
	public Status(int idStatus, String nomStatus) {
		super();
		this.idStatus = idStatus;
		this.nomStatus = nomStatus;
	}
	
	
	
	
	
	
	
	

}
