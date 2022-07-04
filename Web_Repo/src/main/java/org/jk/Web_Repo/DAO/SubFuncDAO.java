package org.jk.Web_Repo.DAO;

import java.util.List;
import org.jk.Web_Repo.Entity.SubFuncPOJO;

public interface SubFuncDAO 
{
	public int addSubFunction(SubFuncPOJO function);
	List<SubFuncPOJO> getAllSubFunctions();
	void deleteSubFunction(int id);
	int updateSubFunction(SubFuncPOJO function); 
	SubFuncPOJO getSubFunction(int id);
	public List<SubFuncPOJO> getSubFuncByCategory(String category);
}
