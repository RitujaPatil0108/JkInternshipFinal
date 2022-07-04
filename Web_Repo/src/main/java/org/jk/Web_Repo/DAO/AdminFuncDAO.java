package org.jk.Web_Repo.DAO;
import org.jk.Web_Repo.Entity.AdminFuncPOJO;

public interface AdminFuncDAO 
{
	public boolean validate(String username,String password);
	int updateAdminPasswordFunction(String username, String password); 
}

