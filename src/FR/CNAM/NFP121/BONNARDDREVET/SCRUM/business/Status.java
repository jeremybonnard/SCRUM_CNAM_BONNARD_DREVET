package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business;

import java.io.Serializable;

/**
 * 
 * @author Vincent
 *
 *Classe Status Decrivant le status d'une tache
 *Cette classe implémente l'interface serializable
 *Elle dispose de 2 attributs:
 *		- idStatus
 *		- nom Status
 *
 *
 */



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
	
	/**
	 * Constructeur complet de la classe Status
	 * @param idStatus
	 * 		Fait reference à l'id du status
	 * @param nomStatus
	 * 		Fait reference au nom du status
	 */
	public Status(int idStatus, String nomStatus) {
		super();
		this.idStatus = idStatus;
		this.nomStatus = nomStatus;
	}
	
	
	
	
	
	
	
	

}
