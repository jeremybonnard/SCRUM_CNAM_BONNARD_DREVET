package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business;

import java.io.Serializable;

/**
 * Classe TypeTache décrivant le type d'une tache
 * Cette classe implemente l'interface serializable
 * elle dispose de 3 attributs:
 * 	- idTypeTache
 * 	- nomTypeTache
 * 	-couleurTypeTache
 */




public class TypeTache implements Serializable {

	private int idTypeTache;
	private String nomTypeTache;
	private String couleurTypeTache;
	
	
	/*
	 * Getter Setter
	 */
	public int getIdTypeTache() {
		return idTypeTache;
	}
	public void setIdTypeTache(int idTypeTache) {
		this.idTypeTache = idTypeTache;
	}
	public String getNomTypeTache() {
		return nomTypeTache;
	}
	public void setNomTypeTache(String nomTypeTache) {
		this.nomTypeTache = nomTypeTache;
	}
	public String getCouleurTypeTache() {
		return couleurTypeTache;
	}
	public void setCouleurTypeTache(String couleurTypeTache) {
		this.couleurTypeTache = couleurTypeTache;
	}
	
	/*
	 * Constructeur Vide
	 */
	 

	/**
 	* Constructeur vide de la classe TypeTache
	*/
	 
	 
	public TypeTache() {
		super();
	}
	
	
	/*
	 * Constructeur complet
	 */
	 
	 
	 /**
	  * Constructeur complet de la classe TypeTache
	  * 
	  * @param idTypeTache
	  * 	numero de la tache
	  * @param nomTypeTache
	  * 	nom de la tache
	  * @param couleurTypeTache
	  * 	couleur en hexadecimal de la tache
	  * 
	  */
	public TypeTache(int idTypeTache, String nomTypeTache, String couleurTypeTache) {
		super();
		this.idTypeTache = idTypeTache;
		this.nomTypeTache = nomTypeTache;
		this.couleurTypeTache = couleurTypeTache;
	}
	
	
	
	
	
	
	
	
	
}
