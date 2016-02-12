package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business;

import java.util.Date;

public class HistoriqueTache {
	
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
	public HistoriqueTache() {
		super();
	}
	
	
	/*
	 * Constructeur sans date
	 */
	public HistoriqueTache(Tache tacheEnCours, Status statusEnCours) {
		super();
		this.tacheEnCours = tacheEnCours;
		this.statusEnCours = statusEnCours;
	}
	
	
	
	/*
	 * Constructeur complet
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
	public HistoriqueTache(Tache tacheEnCours, Date dateDebut, Status statusEnCours) {
		super();
		this.tacheEnCours = tacheEnCours;
		this.dateDebut = dateDebut;
		this.statusEnCours = statusEnCours;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
