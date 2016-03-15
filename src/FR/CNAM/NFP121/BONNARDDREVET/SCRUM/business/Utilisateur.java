package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Utilisateur implements Serializable , Cloneable {

	/*
	 * 
	 *Variables
	 *
	 */
	private static int idUtilisateurMax;
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
	
	
	
	public Utilisateur() {
		super();
		this.idUtilisateur = Utilisateur.idUtilisateurMax;
		Utilisateur.idUtilisateurMax++;
	}
	
	
	
	/*
	 * Constructeur complet avec tache personne
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
