package org.jk.Web_Repo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import org.jk.Web_Repo.DAO.MainFuncDAOImpl;
import org.jk.Web_Repo.DAO.SubFuncDAOImpl;
import org.jk.Web_Repo.Entity.MainFuncPOJO;
import org.jk.Web_Repo.Entity.SubFuncPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@MultipartConfig

public class UserViewController 
{
	@Autowired
	MainFuncDAOImpl mainfuncDAOImpl;
	
	@Autowired
	SubFuncDAOImpl subfuncDAOImpl;

	@ModelAttribute("functionPOJO")
	MainFuncPOJO getMainFuncPOJO() 
	{
		return new MainFuncPOJO();
	}
	
	@ModelAttribute("subfunctionPOJO")
	SubFuncPOJO getSubFuncPOJO() 
	{
		return new SubFuncPOJO();
	}
	
	
	@RequestMapping(value = "/userView")
	public String userView(Model model, @ModelAttribute("functionPOJO") MainFuncPOJO functionPOJO) 
	{
		List<MainFuncPOJO> lis = mainfuncDAOImpl.getAllMainFunctions(); 
	    model.addAttribute("functions",lis);
		return "userView";
	}
	
	private String temp;
	@RequestMapping(value = "/showfuncDetails")
	public String showDetails(Model model, @RequestParam("title")String title, @ModelAttribute("functionPOJO") MainFuncPOJO function, @ModelAttribute("subfunctionPOJO") SubFuncPOJO subfunction) 
	{
		System.out.println("Getting the title: "+title);
		temp = title;
		List<SubFuncPOJO> lis = subfuncDAOImpl. getSubFuncByCategory(title);
		model.addAttribute("subfunctions", lis);
		return "userView2";
	}
	
}
