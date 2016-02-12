package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business;

import java.util.List;

public class Tache {
	
	private int idTache;
	private String nomTache;
	private Status statusEnCours;
	private List<Utilisateur> utilisateurTache;
	
	
	
	/*
	 * getter setter
	 */
	
	public int getIdTache() {
		return idTache;
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
	public Tache(int idTache, String nomTache, Status statusEnCours) {
		super();
		this.idTache = idTache;
		this.nomTache = nomTache;
		this.statusEnCours = statusEnCours;
	}
	
	
	
	/*
	 * Constructeur complet
	 */
	public Tache(int idTache, String nomTache, Status statusEnCours, List<Utilisateur> utilisateurTache) {
		super();
		this.idTache = idTache;
		this.nomTache = nomTache;
		this.statusEnCours = statusEnCours;
		this.utilisateurTache = utilisateurTache;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
