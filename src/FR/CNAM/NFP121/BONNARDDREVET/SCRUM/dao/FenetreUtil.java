package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Tache;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Utilisateur;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui.AjoutUtilisateur;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui.Fenetre;

/**
 * Classe FenetreUtil permettant la manipulation de la fenetre principal et tous ces éléments
 * Cette classe Comporte 2 methodes:
 * 	- actualiserUtilisateur
 * 	- actualiserTacher
 */



public class FenetreUtil {
	
	/**
	 *La methode actualiserUtilisateur permet de mettre à jour la barre d'outils "Equipe" et d'y ajouter le nom de l'utilisateur venant d'etre enregistrer au menu.
	 *elle gere aussi l'affichage des propriétés affecté à lutilisateur (nom,prenom,tache confiée)
	 */
	
	

	public static void actualiserUtilisateur()
	{
// Recuperation du menu Equipe
		JMenu MenuEquipe = Fenetre.fenetreMere.getMenuEquipe();
// Suppression de l'existent.
		MenuEquipe.removeAll();
// Ajout de Ajout Utilisateur
		JMenuItem mntmAjoutUtilisateur = new JMenuItem("Ajout Utilisateur");
		mntmAjoutUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AjoutUtilisateur nvUtilisateur = new AjoutUtilisateur();
				nvUtilisateur.setVisible(true);
			}
		});
		MenuEquipe.add(mntmAjoutUtilisateur);
		
// Ajout de tout les Utilisateurs
		List<Utilisateur> allUtilisateur = UtilisateurUtil.allUtilisateurs();
		for( Utilisateur unUtilisateur : allUtilisateur)
		{
			JMenuItem menuUtilisateur = new JMenuItem(unUtilisateur.getNomUtilisateur()+"  "+unUtilisateur.getPrenomUtilisateur());
			menuUtilisateur.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JOptionPane InfoUtilisateur = new JOptionPane();
// Sur click affichage des info
// DATE EN ANGLAIS ESSAYER DE CHANGER EN FR
					String sInfoUtilisateur = " Nom : "+unUtilisateur.getNomUtilisateur()+"\n Prenom  : "+unUtilisateur.getPrenomUtilisateur()+".\n Date de Naissance : "+unUtilisateur.getNaissanceUtilisateur()+"\n Adresse Mail : "+unUtilisateur.getMailUtilisateur();
				
// A essayer de faire fonctionner : donne les tache de la personne					
					/*if(unUtilisateur.getTachesUtilisateur().isEmpty())
					{
						sInfoUtilisateur = sInfoUtilisateur+" N'est actuellement sur aucune Tache.";
					}
					else 
					{
						sInfoUtilisateur = sInfoUtilisateur+" Est actuellement sur les taches suivante : ";
						for (Tache uneTacheUtilisateur : unUtilisateur.getTachesUtilisateur())
						{
							sInfoUtilisateur = sInfoUtilisateur+uneTacheUtilisateur.getNomTache()+", ";
						}

					}*/
					InfoUtilisateur.showMessageDialog(InfoUtilisateur, sInfoUtilisateur,"Information de "+unUtilisateur.getNomUtilisateur()+"  "+unUtilisateur.getNomUtilisateur(), JOptionPane.INFORMATION_MESSAGE);
				}
			});
			MenuEquipe.add(menuUtilisateur);
		}
	}
	
	
	
	//placement des taches sur le tableau

	
	/**
	 * Methode permettant d'actualiser les donn�es du tableau
	 * 
	 */
	
	
	
	public static void actualiserTache(){
		

		List<tacheGUI[]> tableauDesTaches = new ArrayList<tacheGUI[]>();
		tacheGUI[] titres = {new tacheGUI("A faire",false), new tacheGUI("En D�vellopement",false), new tacheGUI("En Test",false),new tacheGUI("Fini",false)};
		tableauDesTaches.add(titres);
		List<Tache> allTache = TacheUtils.allTaches();
		
		Iterator i =  allTache.iterator();
//		tacheGUI[] ligneTache = {null,null,null,null};
		while(i.hasNext())
		{
			Tache uneTache = (Tache) i.next();
			
			if(uneTache.getStatusEnCours().getIdStatus()==1)
			{
				tacheGUI[] ligneTache = {new tacheGUI(uneTache.getNomTache(),true), new tacheGUI("",false),new tacheGUI("",false),new tacheGUI("",false)};
				tableauDesTaches.add(ligneTache);
				
			}
			else if(uneTache.getStatusEnCours().getIdStatus()==2)
			{
				tacheGUI[] ligneTache = { new tacheGUI("",false),new tacheGUI(uneTache.getNomTache(),true), new tacheGUI("",false),new tacheGUI("",false)};
				tableauDesTaches.add(ligneTache);
			}
			else if(uneTache.getStatusEnCours().getIdStatus()==3)
			{
				tacheGUI[] ligneTache = { new tacheGUI("",false), new tacheGUI("",false),new tacheGUI(uneTache.getNomTache(),true),new tacheGUI("",false)};
				tableauDesTaches.add(ligneTache);
			}			
			else if(uneTache.getStatusEnCours().getIdStatus()==4)
			{
				tacheGUI[] ligneTache = { new tacheGUI("",false), new tacheGUI("",false),new tacheGUI("",false),new tacheGUI(uneTache.getNomTache(),true)};
				tableauDesTaches.add(ligneTache);
			}			
			else
			{
				
			}
			
			
		}
		
		
	}
	
	
}
