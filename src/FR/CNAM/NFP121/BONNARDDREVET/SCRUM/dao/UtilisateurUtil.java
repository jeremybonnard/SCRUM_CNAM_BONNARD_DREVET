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

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Utilisateur;

public class UtilisateurUtil {
	/*
	 * Fonction de sauvegarde d'un utilisateur
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
				
				
				
			
		
		// A Faire!!!
		
		return allUtilisateurs;
		
		
		
	}
	
	// getUtilisateurParNomPrenom renvoie un utilisateur grace a son nom prenom
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
	
	
	
}
