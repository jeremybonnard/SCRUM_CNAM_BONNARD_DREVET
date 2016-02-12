package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business;

import java.util.List;

public class Tache {
	
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
	
	/*
	 * Constructeur vide
	 */
	
	
	public Tache() {
		super();
	}
	
	
	/*
	 * Constructeur sans utilisateur
	 */
	public Tache(int idTache, String nomTache, Status statusEnCours, TypeTache typeTache) {
		super();
		this.idTache = idTache;
		this.nomTache = nomTache;
		this.statusEnCours = statusEnCours;
		this.typeTache = typeTache;
	}
	
	
	
	/*
	 * Constructeur complet
	 */
	public Tache(int idTache, String nomTache, Status statusEnCours, List<Utilisateur> utilisateurTache, TypeTache typeTache) {
		super();
		this.idTache = idTache;
		this.nomTache = nomTache;
		this.statusEnCours = statusEnCours;
		this.utilisateurTache = utilisateurTache;
		this.typeTache = typeTache;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
