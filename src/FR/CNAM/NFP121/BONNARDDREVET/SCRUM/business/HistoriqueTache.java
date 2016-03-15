package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @author Vincent
 * 
 * HistoriqueTache est la classe représentant l'historique d'une tache.
 * Elle implémente l'interface Serializable
 * Elle dispose de 4 attributs:
 * 		- tacheEnCours de type Tache
 * 		- dateDebut de type Date
 * 		- dateFin de type Date
 *  	- statuEnCours de type Status
 * 
 * 
 *
 */



public class HistoriqueTache implements Serializable {
	
	private Tache tacheEnCours;
	private Date dateDebut;
	private Date dateFin;
	private Status statusEnCours;
	
	
	
	/*
	 * Getter setter
	 */
	public Tache getTacheEnCours() {
		return tacheEnCours;
	}
	public void setTacheEnCours(Tache tacheEnCours) {
		this.tacheEnCours = tacheEnCours;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Status getStatusEnCours() {
		return statusEnCours;
	}
	public void setStatusEnCours(Status statusEnCours) {
		this.statusEnCours = statusEnCours;
	}
	
	
	/*
	 * Constructeur Vide
	 */
	
	/**
	 * Constructeur Vide de la classe HistoriqueTache
	 */
	public HistoriqueTache() {
		super();
	}
	
	
	/*
	 * Constructeur sans date
	 */
	
	/**
	 * Constructeur de la classe HistoriqueTache
	 * 
	 * 
	 * @param tacheEnCours
	 * 		fait reference à la tache en cours
	 * @param statusEnCours
	 * 		fait referenceau status en cours de la tache
	 */
	
	
	
	public HistoriqueTache(Tache tacheEnCours, Status statusEnCours) {
		super();
		this.tacheEnCours = tacheEnCours;
		this.statusEnCours = statusEnCours;
	}
	
	
	
	/*
	 * Constructeur complet
	 */
	
	
	/**
	 * Constructeur complet pour la classe HistoriqueTache avec tout les attributs
	 * @param tacheEnCours
	 * @param dateDebut
	 * @param dateFin
	 * @param statusEnCours
	 */
	public HistoriqueTache(Tache tacheEnCours, Date dateDebut, Date dateFin, Status statusEnCours) {
		super();
		this.tacheEnCours = tacheEnCours;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.statusEnCours = statusEnCours;
	}
	
	/*
	 * Constructeur sans date de fin
	 */
	
	/**
	 * Constructeur de la classe HistoriqueTache sans l'attribut dateFin
	 * 
	 * @param tacheEnCours
	 * @param dateDebut
	 * @param statusEnCours
	 */
	public HistoriqueTache(Tache tacheEnCours, Date dateDebut, Status statusEnCours) {
		super();
		this.tacheEnCours = tacheEnCours;
		this.dateDebut = dateDebut;
		this.statusEnCours = statusEnCours;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
