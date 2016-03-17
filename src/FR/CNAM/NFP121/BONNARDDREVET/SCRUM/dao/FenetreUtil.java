package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
					String sInfoUtilisateur = unUtilisateur.getNomUtilisateur()+"  "+unUtilisateur.getPrenomUtilisateur()+". Date de Naissance : "+unUtilisateur.getNaissanceUtilisateur()+". Adresse Mail : "+unUtilisateur.getMailUtilisateur();
				
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
	
	
	
	

	
	public static void actualiserTache(){
		TableModel dataModelTache = new AbstractTableModel(){
			
		};
		
		Fenetre.fenetreMere.getTableTache().setModel(dataModelTache);
	}
}
