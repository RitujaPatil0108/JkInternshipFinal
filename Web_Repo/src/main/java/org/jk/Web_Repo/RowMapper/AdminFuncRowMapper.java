package org.jk.Web_Repo.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jk.Web_Repo.Entity.AdminFuncPOJO;
import org.springframework.jdbc.core.RowMapper;

public class AdminFuncRowMapper implements RowMapper<AdminFuncPOJO> 
{
	@Override
	public AdminFuncPOJO mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		// TODO Auto-generated method stub
		AdminFuncPOJO pojo = new AdminFuncPOJO();
		pojo.setUsername(rs.getString(1));
		pojo.setPassword(rs.getString(2));
		return pojo;
	}
}
