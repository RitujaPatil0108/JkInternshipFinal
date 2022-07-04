package org.jk.Web_Repo.DAO;
import java.util.List;
import org.jk.Web_Repo.Entity.MainFuncPOJO;

public interface MainFuncDAO 
{
	public int addMainFunction(MainFuncPOJO function);
	List<MainFuncPOJO> getAllMainFunctions();
	void deleteMainFunction(int id);
	int updateMainFunction(MainFuncPOJO function); 
	MainFuncPOJO getMainFunction(int id);
}

