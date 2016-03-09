package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business;

import java.io.Serializable;
import java.util.List;

public class Tache implements Serializable{
	
	private static int idTacheMax;
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
	public String toString() {
		return "Tache [idTache=" + idTache + ", nomTache=" + nomTache + ", statusEnCours=" + statusEnCours
				+ ", utilisateurTache=" + utilisateurTache + ", typeTache=" + typeTache + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
