package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business;

public class TypeTache {

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
	public TypeTache() {
		super();
	}
	
	
	/*
	 * Constructeur complet
	 */
	public TypeTache(int idTypeTache, String nomTypeTache, String couleurTypeTache) {
		super();
		this.idTypeTache = idTypeTache;
		this.nomTypeTache = nomTypeTache;
		this.couleurTypeTache = couleurTypeTache;
	}
	
	
	
	
	
	
	
	
	
}
