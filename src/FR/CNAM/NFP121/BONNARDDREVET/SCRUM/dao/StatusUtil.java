package FR.CNAM.NFP121.BONNARDDREVET.SCRUM.dao;

import FR.CNAM.NFP121.BONNARDDREVET.SCRUM.business.Status;

public class StatusUtil {
	
	public static Status getStatusDepart()
	{
		return new Status(0,"A Faire");
	}

}
