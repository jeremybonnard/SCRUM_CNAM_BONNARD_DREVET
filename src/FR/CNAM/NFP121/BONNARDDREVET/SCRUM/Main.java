package FR.CNAM.NFP121.BONNARDDREVET.SCRUM;

import java.io.IOException;

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Utilisateur;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao.TacheUtils;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao.UtilisateurUtil;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui.AjoutUtilisateur;
import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.gui.Fenetre;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fenetre fenetreprincipal = new Fenetre();
		fenetreprincipal.setVisible(true);
		System.out.println(TacheUtils.allTaches());
		

	}

}
