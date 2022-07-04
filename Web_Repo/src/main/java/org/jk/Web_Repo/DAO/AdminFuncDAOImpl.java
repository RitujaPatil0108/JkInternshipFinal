package org.jk.Web_Repo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.jk.Web_Repo.Entity.AdminFuncPOJO;
import org.jk.Web_Repo.RowMapper.AdminFuncRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class AdminFuncDAOImpl implements AdminFuncDAO
{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean validate(String username, String password) 
	{
		// TODO Auto-generated method stub
		String query = "select * from adminlogin where username=?";
		Object[] args = { username };
		List<AdminFuncPOJO> ls = new ArrayList<AdminFuncPOJO>();
		ls = jdbcTemplate.query(query, args, new AdminFuncRowMapper());
		if(ls.size()==0) 
		{
			return false;
		}
		ls.get(0).getPassword();
		if(ls.get(0).getPassword().equals(password)) 
		{
			return true;
		}
		System.out.println(ls.get(0).getPassword());
		return false;
	}

	@Override
	public int updateAdminPasswordFunction(String username, String password) 
	{
		// TODO Auto-generated method stub
		 String sql = "update adminlogin set password = ? where username = ?"; 
		 Object[] args1 = {password, username}; 
		 int recordsUpdated = jdbcTemplate.update(sql, args1); 
		 return recordsUpdated;
	}

}
