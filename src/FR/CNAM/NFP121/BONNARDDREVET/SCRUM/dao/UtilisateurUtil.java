package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Tache;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Utilisateur;

/** UtilisateursUtil est la classe permettant la manipulation des objets utilisateur.
 *
 * elle comporte 5 methodes
 * 
 */


public class UtilisateurUtil {
	/*
	 * Fonction de sauvegarde d'un utilisateur
	 */
	 
	 
	 /**
	  * méthode permettant la sauvegarde d'un utilisateur dans un fichier binaire
	  * @param unUtilisateur
	  * 	Prend en parametre une instance de la classe Utilisateur
	  * @return false
	  * 	retourne faut si probleme
	  */
	  
	public static boolean enregistrerUtilisateur(Utilisateur unUtilisateur){
		ObjectOutputStream ObjectOutput = null;
		List<Utilisateur> allUtilisateurs = allUtilisateurs();
		allUtilisateurs.add(unUtilisateur);
		try {
			ObjectOutput = new ObjectOutputStream(new FileOutputStream("lesUtilisateurs.ser", false));
			
			ObjectOutput.writeObject(allUtilisateurs);
			ObjectOutput.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * Fonction de recuperation de tout les utilisateurs.
	 */
	 
	 
	 /**
	  * Methode permettant de recupérer les utilisateurs qui sont présent dans le fichier binaire
	  * @return allUtilisateur
	  * 	retourne une collection contenant tous les utilisateurs enregistrer
	  */
	 
	 
	 
	public static List<Utilisateur> allUtilisateurs(){
		List<Utilisateur> allUtilisateurs = new ArrayList<Utilisateur>();
		File fichier1 = new File("lesUtilisateurs.ser");
		FileInputStream fichierUtilisateur = null;
		BufferedInputStream bufferedInputStream1 = null;
		ObjectInputStream lesUtilisateursEnregistree = null;
		try {
			fichierUtilisateur = new FileInputStream(fichier1);
			bufferedInputStream1 = new BufferedInputStream(fichierUtilisateur);
			lesUtilisateursEnregistree = new ObjectInputStream(bufferedInputStream1);
			
			try {
				return (List<Utilisateur>) lesUtilisateursEnregistree.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lesUtilisateursEnregistree.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allUtilisateurs;
	}
	
	
	
	
	// getUtilisateurParNomPrenom renvoie un utilisateur grace a son nom prenom
	
	
	/**
	 * Methode permettant de rechercher et de retrouver un utilisateur via son nom et son prenom
	 * @param nomPrenom
	 * 	nom et prénom de la personne
	 * @return utilisateurcherche
	 * 	retourne l'utilisateur correspondant au nom et au prénom
	 */
	 
	
	
	
	public static Utilisateur getUtilisateurParNomPrenom( String nomPrenom )
	{
		String[] tableauNomPrenom = nomPrenom.split("  ");
		Utilisateur utilisateurcherche = null;
		for (Utilisateur unUtilisateur : UtilisateurUtil.allUtilisateurs())
		{
			if(tableauNomPrenom[0].equals(unUtilisateur.getNomUtilisateur()) && tableauNomPrenom[1].equals(unUtilisateur.getPrenomUtilisateur()))
			{
				utilisateurcherche = unUtilisateur;
			}
		}
		return utilisateurcherche;
	}
	
	
	
	
	/**
	 * Methode permettant l'ajout d'un utilisateur
	 * @param unUtilisateur
	 * 	Prend en parametre une instance de la classe Utilisateur
	 * @param uneTache
	 * 	Prend en parametre une instance de la classe Tache
	 */
	public static void ajoutTacheUtilisateur(Utilisateur unUtilisateur, Tache uneTache)
	{
		List<Tache> listeTache = new ArrayList<Tache>();
		if(unUtilisateur.getTachesUtilisateur()==null){
			listeTache.add(uneTache);
		}
		else{
			listeTache.addAll(unUtilisateur.getTachesUtilisateur());
			listeTache.add(uneTache);
		}
		
		
		Utilisateur nouveauUtilisateur = null;
		try {
			nouveauUtilisateur = unUtilisateur.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nouveauUtilisateur.setTachesUtilisateur(listeTache);
		
		UtilisateurUtil.modifierUtilisateur(unUtilisateur, nouveauUtilisateur);
		
	}
	
	
	/**
	 * methode permettant la modification d'un utilisateur en le supprimant et en créant un autre
	 * @param ancienUtilisateur
	 * 	Prend en parametre une instance de la classe Utilisateur faisant reference à un ancien utilisateur
	 * @param nouveauUtilisateur
	 * 	Prend en paramtre une instance de la classe Utilisateur faisant reference au nouveau utilisateur
	 */
	
	
	
	
	public static void modifierUtilisateur(Utilisateur ancienUtilisateur, Utilisateur nouveauUtilisateur)
	{
		ObjectOutputStream ObjectOutput = null;
		List<Utilisateur> allUtilisateurs = allUtilisateurs();
		allUtilisateurs.remove(ancienUtilisateur);
		allUtilisateurs.add(nouveauUtilisateur);
		try {
			ObjectOutput = new ObjectOutputStream(new FileOutputStream("lesUtilisateurs.ser", false));
			
			ObjectOutput.writeObject(allUtilisateurs);
			ObjectOutput.close();
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
}
