package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao;

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Status;

/**
 * StatusUtil est la classe  permettant d'interagir avec les objets de Status
 */

public class StatusUtil {
	
	/**
	 * Cette méthode definit l'id et l'action a effectuer initialement
	 * @return Statuc(0,"A Faire")
	 * 	retourn l'id et l'action de la tache créer
	 */
	
	
	public static Status getStatusDepart()
	{
		return new Status(0,"A Faire");
	}

}
