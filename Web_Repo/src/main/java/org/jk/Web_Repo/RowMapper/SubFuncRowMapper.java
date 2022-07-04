package org.jk.Web_Repo.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.jk.Web_Repo.Entity.SubFuncPOJO;
import org.springframework.jdbc.core.RowMapper;

public class SubFuncRowMapper implements RowMapper<SubFuncPOJO> 
{
	@Override
	public SubFuncPOJO mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		// TODO Auto-generated method stub
		SubFuncPOJO pojo=new SubFuncPOJO();
		pojo.setId(rs.getInt(1));
		pojo.setTitle(rs.getString(2));
		pojo.setDescription(rs.getString(3));
		pojo.setUrl(rs.getString(4));
		pojo.setCategory(rs.getString(5));
		return pojo;
	}
}
