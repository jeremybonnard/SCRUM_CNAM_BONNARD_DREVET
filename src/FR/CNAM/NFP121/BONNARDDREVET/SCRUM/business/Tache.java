package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Vincent
 *
 *Classe Tache Decrivant les caracteristiques d'une Tache
 *Cette classe implémente l'interface serializable
 *Elle dispose de 6 attributs
 *		- idTacheMax
 *		- idTache
 *		- nomTache
 *		- statusEnCours
 *		- utilisateurTache
 *		- typeTache
 *
 *
 */





public class Tache implements Serializable, Cloneable {
	
	public static int idTacheMax;
	private int idTache;
	private String nomTache;
	private Status statusEnCours;
	private List<Utilisateur> utilisateurTache;
	private TypeTache typeTache;
	
	
	
	/*
	 * getter setter
	 */
	
	public int getIdTache() {
		return idTache;
	}
	public TypeTache getTypeTache() {
		return typeTache;
	}
	public void setTypeTache(TypeTache typeTache) {
		this.typeTache = typeTache;
	}
	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}
	public String getNomTache() {
		return nomTache;
	}
	public void setNomTache(String nomTache) {
		this.nomTache = nomTache;
	}
	public Status getStatusEnCours() {
		return statusEnCours;
	}
	public void setStatusEnCours(Status statusEnCours) {
		this.statusEnCours = statusEnCours;
	}
	public List<Utilisateur> getUtilisateurTache() {
		return utilisateurTache;
	}
	public void setUtilisateurTache(List<Utilisateur> utilisateurTache) {
		this.utilisateurTache = utilisateurTache;
	}
	public static int getIdTacheMax() {
		return idTacheMax;
	}
	public static void setIdTacheMax(int idTacheMax) {
		Tache.idTacheMax = idTacheMax;
	}
	
	/*
	 * Constructeur vide
	 */
	
	public Tache() {
		super();
		this.idTache = Tache.idTacheMax;
		Tache.idTacheMax++;
	}
	
	
	/*
	 * Constructeur sans utilisateur
	 */
	
	
	/**
	 * Constructeur de la classe Tache sans utilisateur.
	 * @param nomTache
	 * @param statusEnCours
	 * @param typeTache
	 */
	public Tache(String nomTache, Status statusEnCours, TypeTache typeTache) {
		super();
		this.idTache =Tache.idTacheMax;
		this.nomTache = nomTache;
		this.statusEnCours = statusEnCours;
		this.typeTache = typeTache;
		Tache.idTacheMax++;
	}
	
	
	
	/*
	 * Constructeur complet
	 */
	
	/**
	 * Constructeur complet de la classe Tache
	 * @param nomTache
	 * @param statusEnCours
	 * @param utilisateurTache
	 * @param typeTache
	 */
	public Tache( String nomTache, Status statusEnCours, List<Utilisateur> utilisateurTache, TypeTache typeTache) {
		super();
		this.idTache = Tache.idTacheMax;
		this.nomTache = nomTache;
		this.statusEnCours = statusEnCours;
		this.utilisateurTache = utilisateurTache;
		this.typeTache = typeTache;
		Tache.idTacheMax++;
	}
	/*
	 * ToString
	 * @see java.lang.Object#toString()
	 */
	@Override
	
	
	/**
	 * Methode retournant les variables de la classe
	 */
	public String toString() {
		return "Nom de la tache : " + nomTache + "\n" + "Status de la Tache : " + statusEnCours.toString() + "\n"
				+ "Le ou Les Utilisateurs de la Tache : " + utilisateurTache + "\n"+ "Le type de Tache :" + typeTache.toString();
	}
	
	
	
	
	public Tache clone() throws CloneNotSupportedException{ 
		return (Tache) super.clone(); 
		} 
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
