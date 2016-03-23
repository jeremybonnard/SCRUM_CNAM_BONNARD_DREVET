package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Tache;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Utilisateur;

/** TacheUtils est la classe permettant d'interagir avec les objets Tache
 * Elle est composée de 2 méthodes
 */


public class TacheUtils {
	
	
	/** Méthode permettant d'enregistrer une tache créer dans un fichier binaire
	 * @param unTache
	 * 	une instance d'une classe Tache
	 * @return False
	 * 	retour false en cas d'erreur
	 */
	 
	public static boolean enregistrerTache(Tache unTache){
		ObjectOutputStream ObjectOutput = null;
		List<Tache> allTaches = allTaches();
		allTaches.add(unTache);
		try {
			ObjectOutput = new ObjectOutputStream(new FileOutputStream("lesTaches.ser", false));
			
			ObjectOutput.writeObject(allTaches);
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
	 * Fonction de recuperation de tout les Taches.
	 */
	 
	 
	 /** methode permettant la récuperation de toute les taches crées
	  * 
	  * @return allTaches
	  * 	retourne toutes les taches qui ont été chargé depuis le fichier binaire
	  */
	  
	public static List<Tache> allTaches(){
		List<Tache> allTaches = new ArrayList<Tache>();
		File fichier1 = new File("lesTaches.ser");
		FileInputStream fichierTache = null;
		BufferedInputStream bufferedInputStream1 = null;
		ObjectInputStream lesTachesEnregistree = null;
		try {
			fichierTache = new FileInputStream(fichier1);
			bufferedInputStream1 = new BufferedInputStream(fichierTache);
			lesTachesEnregistree = new ObjectInputStream(bufferedInputStream1);
			
			try {
				return (List<Tache>) lesTachesEnregistree.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lesTachesEnregistree.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allTaches;
	}
	
	/**
	 * Methode permettant la modification des taches
	 * @param idAncienTache
	 * 	Faire reference à l'identifiant de l'ancien tache
	 * @param nouveauTache
	 * 	Faire reference à un instance de la classe Tache
	 * 
	 */
	
	
	
	public static void modifiertache(int idAncienTache, Tache nouveauTache)
	{
		ObjectOutputStream ObjectOutput = null;
		List<Tache> allTaches = allTaches();		
		allTaches.remove(idAncienTache);
		allTaches.add(nouveauTache);
		try {
			ObjectOutput = new ObjectOutputStream(new FileOutputStream("lesTaches.ser", false));
			
			ObjectOutput.writeObject(allTaches);
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
