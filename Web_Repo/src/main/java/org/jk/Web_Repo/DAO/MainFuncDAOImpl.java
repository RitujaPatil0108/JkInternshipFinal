package org.jk.Web_Repo.DAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.jk.Web_Repo.Entity.MainFuncPOJO;
import org.jk.Web_Repo.RowMapper.MainFuncRowMapper;


@Repository
public class MainFuncDAOImpl implements MainFuncDAO 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	// getting all the main functions( main departments) from the database
	@Override
	public List<MainFuncPOJO> getAllMainFunctions() 
	{
		String query="select * from mainfunc";
		List<MainFuncPOJO> ls = new ArrayList<MainFuncPOJO>();
		ls = jdbcTemplate.query(query,  new MainFuncRowMapper());
		return ls;
	}
	
	// Calculating the number of records stored in the mainfunc table
	public int getSize() 
	{
		String query="select * from mainfunc";
		List<MainFuncPOJO> ls = new ArrayList<MainFuncPOJO>();
		ls = jdbcTemplate.query(query, new MainFuncRowMapper());
		if(ls.size()==0)return 0;
		MainFuncPOJO pojo=ls.get(ls.size()-1);
		return pojo.getId();
	}

	// function to add a record (function) into the table/ database
	@Override
	public int addMainFunction(MainFuncPOJO function)
	{
		String add = "insert into mainfunc values(?,?,?)";
		Object[] args = {function.getId(), function.getTitle(), function.getDescription()};
		int addF = jdbcTemplate.update(add, args);
		if (addF == 1)
		{
			System.out.println("Added Successfully!");
		}
		
		else
		{
			System.out.println("Failure Occurred while Adding ");
		}
		return 0;
	}
	
	// fetching the record details using the record id
	
	  @Override public MainFuncPOJO getMainFunction(int id) 
	  { 
		  String sql = "select * from mainfunc where id = ?"; 
		  MainFuncPOJO function = jdbcTemplate.queryForObject(sql, new MainFuncRowMapper(), id); 
		  return function; 
      }
	  
	  // update function to update a record incase any error
	  
	  @Override public int updateMainFunction(MainFuncPOJO function) 
	  { 
		  String sql = "update mainfunc set title = ?, description = ? where id = ?"; 
		  Object[] args = {function.getTitle(), function.getDescription(), function.getId()}; 
		  int recordsUpdated = jdbcTemplate.update(sql, args); 
		  return recordsUpdated; 
      }
	  
	  // function to delete or remove any record from the database
	  
	@Override public void deleteMainFunction(int id) 
	{ 
		String sql = "delete from mainfunc where id = ?"; jdbcTemplate.update(sql, id); 
	}
}
