package org.jk.Web_Repo.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jk.Web_Repo.Entity.MainFuncPOJO;
import org.springframework.jdbc.core.RowMapper;

public class MainFuncRowMapper implements RowMapper<MainFuncPOJO> 
{
	@Override
	public MainFuncPOJO mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		// TODO Auto-generated method stub
		MainFuncPOJO pojo=new MainFuncPOJO();
		pojo.setId(rs.getInt(1));
		pojo.setTitle(rs.getString(2));
		pojo.setDescription(rs.getString(3));
		return pojo;
	}
}
