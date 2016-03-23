package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao;


/**
 * La classe EmailValidator permet la verification des adresse mail.
 */


  
public class EmailValidator {
	
	
	
	/**
	 * La methode est Valide permet la verification d'une adresse mail au moyen d'une expression regulière (regex)
	 * @return true ou false
	 * 	Retourne vrai ou faux si la condition est respecté ou non.
	 * @param email
	 * 	Prend en parametre une adresse email.
	 */
	public boolean estValide(String email){
		if(email.matches("^(.*)@(.*)\\.(.{2,4})$")){
			return true;
		}
		else{
			return false;
		}
	}
}
