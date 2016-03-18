package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao;

public class EmailValidator {
	public boolean estValide(String email){
		if(email.matches("^(.*)@(.*)\\.(.{2,4})$")){
			return true;
		}
		else{
			return false;
		}
	}
}
