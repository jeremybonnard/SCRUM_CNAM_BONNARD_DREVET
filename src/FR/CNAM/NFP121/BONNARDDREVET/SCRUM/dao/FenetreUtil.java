package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Tache;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Utilisateur;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui.AjoutUtilisateur;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui.Fenetre;

/**
 * Classe FenetreUtil permettant la manipulation de la fenetre principal et tous ces Ã©lÃ©ments
 * Cette classe Comporte 2 methodes:
 * 	- actualiserUtilisateur
 * 	- actualiserTacher
 */



public class FenetreUtil {
	
	/**
	 *La methode actualiserUtilisateur permet de mettre Ã  jour la barre d'outils "Equipe" et d'y ajouter le nom de l'utilisateur venant d'etre enregistrer au menu.
	 *elle gere aussi l'affichage des propriÃ©tÃ©s affectÃ© Ã  lutilisateur (nom,prenom,tache confiÃ©e)
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
	 * La methode actualiserTache permet l'affichage, la gestion et enfin l'actualisation des donnée affiche sur les différents JPanel
	 * 
	 * 
	 */
	
	
	
	public static void actualiserTache(){
		
		List<Tache> allTaches = TacheUtils.allTaches();
		Fenetre.fenetreMere.getJPanelAFaire().removeAll();
		Fenetre.fenetreMere.getJPanelEnCours().removeAll();
		Fenetre.fenetreMere.getJPanelEnTest().removeAll();
		Fenetre.fenetreMere.getJPanelFini().removeAll();
		
		Iterator i = allTaches.iterator();
		int iter = 0;
		while(i.hasNext())
		{
			System.out.println(iter);
			iter++;
			Tache uneTache = (Tache) i.next();
			if(uneTache.getStatusEnCours().getIdStatus()==1)
			{
				JTextPane labelinfo = new JTextPane();
				labelinfo.setFocusable(false);
				labelinfo.setText(uneTache.getNomTache());
				labelinfo.setBackground(uneTache.getTypeTache().getCouleurTypeTache());
				String lesOptions[] = { "Afficher les info?","Mettre à l'états: En cours?"};
				labelinfo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						JOptionPane info = new JOptionPane();
						int retourdialog = info.showOptionDialog(info, "Que souhaiter vous faire avec cette tache?", "Option sur la tache ", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null, lesOptions, lesOptions[1]);
						if(retourdialog==0){
							
							JOptionPane infoTache = new JOptionPane();
							infoTache.showMessageDialog(infoTache, uneTache.toString(), uneTache.getNomTache(), JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							int idTache = allTaches.indexOf(uneTache);
							uneTache.setStatusEnCours(StatusUtil.getStatusEnCours());
							TacheUtils.modifiertache(idTache, uneTache);
							FenetreUtil.actualiserTache();
						}
					}
				});
				Fenetre.fenetreMere.getJPanelAFaire().add(labelinfo);
			}
			else if(uneTache.getStatusEnCours().getIdStatus() ==2)
			{
				JTextPane labelinfo = new JTextPane();
				labelinfo.setFocusable(false);
				labelinfo.setText(uneTache.getNomTache());
				labelinfo.setBackground(uneTache.getTypeTache().getCouleurTypeTache());
				String lesOptions[] = { "Afficher les info?","Mettre à l'état: En Test?", "Repasser à l'état : A faire?"};
				labelinfo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						JOptionPane info = new JOptionPane();
						int retourdialog = info.showOptionDialog(info, "Que souhaiter vous faire avec cette tache?", "Option sur la tache ", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null, lesOptions, lesOptions[1]);
						if(retourdialog==0){
							
							JOptionPane infoTache = new JOptionPane();
							infoTache.showMessageDialog(infoTache, uneTache.toString(), uneTache.getNomTache(), JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							if(retourdialog == 1){
								int idTache = allTaches.indexOf(uneTache);
								uneTache.setStatusEnCours(StatusUtil.getStatusEnTest());
								TacheUtils.modifiertache(idTache, uneTache);
								FenetreUtil.actualiserTache();
							}
							else if(retourdialog == 2){
								int idTache = allTaches.indexOf(uneTache);
								uneTache.setStatusEnCours(StatusUtil.getStatusDepart());
								TacheUtils.modifiertache(idTache, uneTache);
								FenetreUtil.actualiserTache();
							}
							else 
							{
								
							}
						}
					}
				});
				Fenetre.fenetreMere.getJPanelEnCours().add(labelinfo);
				
			}
			else if(uneTache.getStatusEnCours().getIdStatus()==3)
			{
				JTextPane labelinfo = new JTextPane();
				labelinfo.setText(uneTache.getNomTache());
				labelinfo.setFocusable(false);
				labelinfo.setBackground(uneTache.getTypeTache().getCouleurTypeTache());
				String lesOptions[] = { "Afficher les info?","Mettre à l'état: Fini?", "Repasser à l'état : En Cours?"};
				labelinfo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						JOptionPane info = new JOptionPane();
						int retourdialog = info.showOptionDialog(info, "Que souhaiter vous faire avec cette tache?", "Option sur la tache ", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null, lesOptions, lesOptions[1]);
						if(retourdialog==0){
							
							JOptionPane infoTache = new JOptionPane();
							infoTache.showMessageDialog(infoTache, uneTache.toString(), uneTache.getNomTache(), JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							if(retourdialog == 1){
								int idTache = allTaches.indexOf(uneTache);
								uneTache.setStatusEnCours(StatusUtil.getStatusFini());
								TacheUtils.modifiertache(idTache, uneTache);
								FenetreUtil.actualiserTache();
							}
							else if(retourdialog == 2){
								int idTache = allTaches.indexOf(uneTache);
								uneTache.setStatusEnCours(StatusUtil.getStatusEnCours());
								TacheUtils.modifiertache(idTache, uneTache);
								FenetreUtil.actualiserTache();
							}
							else 
							{
								
							}
						}
					}
				});
				Fenetre.fenetreMere.getJPanelEnTest().add(labelinfo);
				
			}
			else{
				JTextPane labelinfo = new JTextPane();
				labelinfo.setText(uneTache.getNomTache());
				labelinfo.setBackground(uneTache.getTypeTache().getCouleurTypeTache());
				labelinfo.setFocusable(false);
				labelinfo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						JOptionPane infoTache = new JOptionPane();
						infoTache.showMessageDialog(infoTache, uneTache.toString(), uneTache.getNomTache(), JOptionPane.INFORMATION_MESSAGE);
					}
				});
				Fenetre.fenetreMere.getJPanelFini().add(labelinfo);
				
			}
			Fenetre.fenetreMere.revalidate();
			Fenetre.fenetreMere.revalidate();
		}
		
//		List<tacheGUI[]> tableauDesTaches = new ArrayList<tacheGUI[]>();
//		tacheGUI[] titres = {new tacheGUI("A faire",false), new tacheGUI("En Dévellopement",false), new tacheGUI("En Test",false),new tacheGUI("Fini",false)};
//		tableauDesTaches.add(titres);
//		List<Tache> allTache = TacheUtils.allTaches();
//		
//		Iterator i =  allTache.iterator();
////		tacheGUI[] ligneTache = {null,null,null,null};
//		while(i.hasNext())
//		{
//			Tache uneTache = (Tache) i.next();
//			
//			if(uneTache.getStatusEnCours().getIdStatus()==1)
//			{
//				tacheGUI[] ligneTache = {new tacheGUI(uneTache.getNomTache(),true), new tacheGUI("",false),new tacheGUI("",false),new tacheGUI("",false)};
//				tableauDesTaches.add(ligneTache);
//				
//			}
//			else if(uneTache.getStatusEnCours().getIdStatus()==2)
//			{
//				tacheGUI[] ligneTache = { new tacheGUI("",false),new tacheGUI(uneTache.getNomTache(),true), new tacheGUI("",false),new tacheGUI("",false)};
//				tableauDesTaches.add(ligneTache);
//			}
//			else if(uneTache.getStatusEnCours().getIdStatus()==3)
//			{
//				tacheGUI[] ligneTache = { new tacheGUI("",false), new tacheGUI("",false),new tacheGUI(uneTache.getNomTache(),true),new tacheGUI("",false)};
//				tableauDesTaches.add(ligneTache);
//			}			
//			else if(uneTache.getStatusEnCours().getIdStatus()==4)
//			{
//				tacheGUI[] ligneTache = { new tacheGUI("",false), new tacheGUI("",false),new tacheGUI("",false),new tacheGUI(uneTache.getNomTache(),true)};
//				tableauDesTaches.add(ligneTache);
//			}			
//			else
//			{
//				
//			}
//			
//			
//		}
//		
		
	}
	
	
}
