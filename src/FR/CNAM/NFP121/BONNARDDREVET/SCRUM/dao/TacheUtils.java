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

public class TacheUtils {
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

}
