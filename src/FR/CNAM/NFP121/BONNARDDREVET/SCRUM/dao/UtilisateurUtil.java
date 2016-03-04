package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao;
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

	public static boolean enregistrerUtilisateur(Utilisateur unUtilisateur){
		

		File fichier1 = new File("data.bin");
		
		try {
			FileWriter fileWriter1 = new FileWriter(fichier1);
			FileOutputStream fileOutputStream1 = null;
			try {
				fileOutputStream1 = new FileOutputStream(fichier1);
				ObjectOutputStream objectOutputStream1 = null;
				try {
					objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
					try {
						objectOutputStream1.writeObject(unUtilisateur);
						return true;
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	
		
		
		
		
		
		
		
		
	}
	
	
	public static List<Utilisateur> allUtilisateurs(){
		List<Utilisateur> allUtilisateurs = new ArrayList<Utilisateur>();
		
		File fichier1 = new File("data.bin");
		
		try {
			FileWriter fileWriter1 = new FileWriter(fichier1);
			FileInputStream fileInputStream1 = null;
			try{
				
				fileInputStream1 = new FileInputStream(fichier1);
				ObjectInputStream objectInputStream1 = null;
				
				try {
					objectInputStream1 = new ObjectInputStream(fileInputStream1);
					try {
						objectInputStream1.readObject(allUtilisateurs);
						return true;
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
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
