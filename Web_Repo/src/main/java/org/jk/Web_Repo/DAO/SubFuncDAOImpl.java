package org.jk.Web_Repo.DAO;

import java.util.ArrayList;
import java.util.List;
import org.jk.Web_Repo.Entity.SubFuncPOJO;
import org.jk.Web_Repo.RowMapper.SubFuncRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SubFuncDAOImpl implements SubFuncDAO
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int getSize() 
	{
		String query="select * from subfunc";
		List<SubFuncPOJO> ls = new ArrayList<SubFuncPOJO>();
		ls = jdbcTemplate.query(query, new SubFuncRowMapper());
		if(ls.size()==0)
			return 0;
		SubFuncPOJO pojo=ls.get(ls.size()-1);
		return pojo.getId();
	}
	
	@Override
	public int addSubFunction(SubFuncPOJO function) 
	{
		String add = "insert into subfunc values(?,?,?,?,?)";
		Object[] args = {function.getId(), function.getTitle(), function.getDescription(), function.getUrl(), function.getCategory() };
		int addS = jdbcTemplate.update(add, args);
		if (addS == 1)
		{
			System.out.println("Added Successfully!");
		}
		
		else
		{
			System.out.println("Unlucky :clown_face: ");
		}
		return 0;
	}

	@Override
	public List<SubFuncPOJO> getAllSubFunctions() 
	{
		String query="select * from subfunc";
		List<SubFuncPOJO> ls = new ArrayList<SubFuncPOJO>();
		ls = jdbcTemplate.query(query,  new SubFuncRowMapper());
		return ls;
	}

	@Override
	public void deleteSubFunction(int id) 
	{
		String sql = "delete from subfunc where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public int updateSubFunction(SubFuncPOJO function) 
	{
		String sql = "update subfunc set title = ?, description = ?, url = ?, category = ? where id = ?";
		Object[] args = {function.getTitle(), function.getDescription(), function.getUrl(), function.getCategory(), function.getId()};
		int recordsUpdated = jdbcTemplate.update(sql, args);
		return recordsUpdated;

	}

	@Override
	public SubFuncPOJO getSubFunction(int id) 
	{
		String sql = "select * from subfunc where id = ?";
		SubFuncPOJO function = jdbcTemplate.queryForObject(sql, new SubFuncRowMapper(), id);		
		return function;
	}

	@Override
	public List<SubFuncPOJO> getSubFuncByCategory(String category) 
	{
		String query="select * from subfunc where category=?";
		Object[] args= {category};
		List<SubFuncPOJO> ls = new ArrayList<SubFuncPOJO>();
		ls = jdbcTemplate.query(query, args, new SubFuncRowMapper());
		return ls;

	}
}
