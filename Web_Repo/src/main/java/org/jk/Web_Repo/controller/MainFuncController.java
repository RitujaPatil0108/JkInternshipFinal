package org.jk.Web_Repo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jk.Web_Repo.DAO.MainFuncDAOImpl;
import org.jk.Web_Repo.Entity.MainFuncPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@MultipartConfig

public class MainFuncController 
{
	@Autowired
	MainFuncDAOImpl mainfuncDAOImpl;

	@ModelAttribute("functionPOJO")
	MainFuncPOJO getMainFuncPOJO() 
	{
		return new MainFuncPOJO();
	}
	
	
	@RequestMapping(value = "/addDepartment")
	public String addDepartment() 
	{
		return "addDepartment";
	}
	
	@RequestMapping(value = "/addMainFunction")
	public String addProdut(HttpServletRequest request, @Valid @ModelAttribute("functionPOJO") MainFuncPOJO function, BindingResult br, Model model) throws IOException, ServletException 
	{
		if(br.hasErrors()) 
		{
			return "addDepartment";
		}

		function.setId(mainfuncDAOImpl.getSize() + 1);

		mainfuncDAOImpl.addMainFunction(function);
		List<MainFuncPOJO> lis = mainfuncDAOImpl.getAllMainFunctions();
		model.addAttribute("functions", lis);
		return "adminView";
	}

	
	  @GetMapping("/updateForm") 
	  public String showUpdateForm(@RequestParam("fid")int fiid, @ModelAttribute("functionPOJO") MainFuncPOJO functionabc, Model model) 
	  {
		  System.out.println("Getting the data for id: "+fiid); 
		  functionabc = mainfuncDAOImpl.getMainFunction(fiid); 
		  model.addAttribute("functionPOJO",functionabc);
		  return "Update1"; 
	  }
	  
	  @RequestMapping("/processUpdate") 
	  public String processUpdateForm(Model model,@Valid @ModelAttribute("functionPOJO") MainFuncPOJO functionPOJO, BindingResult br) 
	  {
		  if(br.hasErrors()) 
			{
			    return "Update1";
			}
		  if(mainfuncDAOImpl.updateMainFunction(functionPOJO) == 1) 
		  {
			  System.out.println("Record updated successfully!!"); 
		  } 
		  else 
		  {
		       System.out.println("Error!!!"); 
		  } 
		  List<MainFuncPOJO> lis = mainfuncDAOImpl.getAllMainFunctions(); 
		  model.addAttribute("functions",lis);
	      return "adminView"; 
	  }
	
	@RequestMapping("/deleteDepartment") 
	public String deleteBook(Model model, @RequestParam("id")int id, @ModelAttribute("functionPOJO") MainFuncPOJO function) 
	{ 
		mainfuncDAOImpl.deleteMainFunction(id); 
		List<MainFuncPOJO> lis = mainfuncDAOImpl.getAllMainFunctions(); 
		model.addAttribute("functions",lis);
	    return "adminView"; 
    }
	
}
