package FR.CNAM.NFP121.BONNARDDREVET.SCRUM;

import java.io.IOException;

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Tache;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Utilisateur;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao.TacheUtils;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao.UtilisateurUtil;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui.AjoutUtilisateur;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui.Fenetre;

/**
 * @author Vincent Drevet / Jeremy Bonnard
 * 
 * Point d'entré de notre programme
 * 
 * Cette Classe appelle la classe Fenetre qui représente la fenetre principale de notre programme
 *
 */



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utilisateur.idUtilisateurMax = UtilisateurUtil.allUtilisateurs().size();
		Tache.idTacheMax = TacheUtils.allTaches().size();
		Fenetre fenetreprincipal = new Fenetre();
		fenetreprincipal.setVisible(true);

		

	}

}
