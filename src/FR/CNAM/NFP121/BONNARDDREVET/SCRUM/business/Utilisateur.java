package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 *Classe Utilisateur Decrivant un utilisateur
 *Cette classe implémente l'interface serializable
  *Elle dispose de 7 attributs
  *	- idUtilisateurMax
  * 	- idUtilisateur
  * 	- nomUtilisateur
  * 	- prenomUtilisateur
  * 	- mailUtilisateur
  * 	- naissanceUtilisateur
  * 	- tacheUtilisateur
  * ATTENTION l'attribut idUtilisateurMax est public


public class Utilisateur implements Serializable , Cloneable {

	/*
	 * 
	 *Variables
	 *
	 */
	public static int idUtilisateurMax;
	private int idUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String mailUtilisateur;
	private Date naissanceUtilisateur;
	private List<Tache> tachesUtilisateur = null;
	
	
	/*
	 * Getter setter
	 */
	
	public static int getIdUtilisateurMax() {
		return idUtilisateurMax;
	}
	public static void setIdUtilisateurMax(int idUtilisateurMax) {
		Utilisateur.idUtilisateurMax = idUtilisateurMax;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}
	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}
	public String getMailUtilisateur() {
		return mailUtilisateur;
	}
	public void setMailUtilisateur(String mailUtilisateur) {
		this.mailUtilisateur = mailUtilisateur;
	}
	public Date getNaissanceUtilisateur() {
		return naissanceUtilisateur;
	}
	public void setNaissanceUtilisateur(Date naissanceUtilisateur) {
		this.naissanceUtilisateur = naissanceUtilisateur;
	}
	public List<Tache> getTachesUtilisateur() {
		return tachesUtilisateur;
	}
	public void setTachesUtilisateur(List<Tache> tachesUtilisateur) {
		this.tachesUtilisateur = tachesUtilisateur;
	}
	
	
	
	
	
	/*
	 * Constructeur utilisateur complet sans tache.
	 */
	 
	 
	 /**
	  * Constructeur de la classe Utilisateur sans affectation de tache
	  * @param idUtilisateur
	  * 	numero utilisateur
	  * @param nomUtilisateur
	  * 	nomutilisateur
	  * @param prenomUtilisateur
	  * 	prenomUtilisateur
	  * @param mailUtilisateur
	  * 	mailUtilisateur
	  * @param naissanceUtilisateur
	  * 	date de naissanceUtilisateur
	  * 
	  * le constructeur incremente l'attribut idUtilisateurMax
	  */
	
	public Utilisateur( String nomUtilisateur, String prenomUtilisateur, String mailUtilisateur,
			Date naissanceUtilisateur) {
		super();
		this.idUtilisateur = Utilisateur.idUtilisateurMax;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.mailUtilisateur = mailUtilisateur;
		this.naissanceUtilisateur = naissanceUtilisateur;
		Utilisateur.idUtilisateurMax ++;
	}
	
	
	/*
	 * Constructeur vide
	 */
	
	/**
	 * Constructeur vide de la classe Utilisateur
	 * incremente l'attribut idUtilisateurMax à chaque appelle
	 */
	
	public Utilisateur() {
		super();
		this.idUtilisateur = Utilisateur.idUtilisateurMax;
		Utilisateur.idUtilisateurMax++;
	}
	
	
	
	/*
	 * Constructeur complet avec tache personne
	 */
	 
	 /**
	  * Construcuteur complet de la classe Utilisateur
	  * @param idUtilisateur
	  * 	numero utilisateur
	  * @param nomUtilisateur
	  * 	nom utilisateur
	  * @param prenomUtilisateur
	  * 	prenom utilisateur
	  * @param mailUtilisateur
	  * 	mail utilisateur
	  * @param naissanceUtilisateur
	  * 	date de naissance utilisateur
	  * @param tachesUtilisateur
	  * 	tache affectée à l'utilisateur
	  * Incrementation de l'attribut idUtilisateurMax à chaque appel
	  */
	 
	
	public Utilisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String mailUtilisateur,
			Date naissanceUtilisateur, List<Tache> tachesUtilisateur) {
		super();
		this.idUtilisateur = Utilisateur.idUtilisateurMax;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.mailUtilisateur = mailUtilisateur;
		this.naissanceUtilisateur = naissanceUtilisateur;
		this.tachesUtilisateur = tachesUtilisateur;
		Utilisateur.idUtilisateurMax++;
	}
	
	
	/**
	 * Methode toString permettant de renvoyer sous forme de texte les attributs de la classe
	 * 
	 * @return idutilisateur
	 * @return nomUtilisateur
	 * @return prenomUtilisateur
	 * @return mailUtilisateur
	 * @return naissanceUtilisateur
	 * @return tacheUtilisateur
	 */
	
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", mailUtilisateur=" + mailUtilisateur
				+ ", naissanceUtilisateur=" + naissanceUtilisateur + ", tachesUtilisateur=" + tachesUtilisateur + "]";
	}
	
	public Utilisateur clone() throws CloneNotSupportedException{ 
	return (Utilisateur) super.clone(); 
	} 
	
	
	
	
	
	

	
	
	
	

	
	
	
	
	
}
