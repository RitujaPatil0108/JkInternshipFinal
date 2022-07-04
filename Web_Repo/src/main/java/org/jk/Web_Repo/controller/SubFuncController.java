package org.jk.Web_Repo.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jk.Web_Repo.DAO.SubFuncDAOImpl;
import org.jk.Web_Repo.Entity.MainFuncPOJO;
import org.jk.Web_Repo.Entity.SubFuncPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@MultipartConfig
public class SubFuncController 
{
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
	
	private String temp;
	@RequestMapping(value = "/showDetails")
	public String showDetails(Model model, @RequestParam("title")String title, @ModelAttribute("functionPOJO") MainFuncPOJO function, @ModelAttribute("subfunctionPOJO") SubFuncPOJO subfunction) 
	{
		System.out.println("Getting the title: "+title);
		temp = title;
		List<SubFuncPOJO> lis = subfuncDAOImpl. getSubFuncByCategory(title);
		model.addAttribute("subfunctions", lis);
		return "adminView2";
	}
	
	@RequestMapping(value = "/addFunction")
	public String addFunction() 
	{
		return "addFunction";
	}
	
	@RequestMapping(value = "/addSubFunction")
	public String addProdut(HttpServletRequest request, @Valid @ModelAttribute("subfunctionPOJO") SubFuncPOJO subfunction, BindingResult br, Model model) throws IOException, ServletException 
	{
		if(br.hasErrors()) 
		{
			return "addFunction";
		}
		subfunction.setId(subfuncDAOImpl.getSize() + 1);
		subfunction.setCategory(temp);
		subfuncDAOImpl.addSubFunction(subfunction);
		List<SubFuncPOJO> lis = subfuncDAOImpl. getSubFuncByCategory(temp);
		model.addAttribute("subfunctions", lis);
		return "adminView2";
	}
	
	@RequestMapping("/updateSubForm")
	public String showUpdateForm(@RequestParam("id")int id,@ModelAttribute("subfunctionPOJO") SubFuncPOJO subfunctionPOJO, Model model) 
	{
		System.out.println("Getting the  data for id: "+id);
		subfunctionPOJO = subfuncDAOImpl.getSubFunction(id);
		 model.addAttribute("subfunctionPOJO",subfunctionPOJO); 
		return "updateSubForm";
	}

	@PostMapping("/processSubUpdate")
	public String processUpdateForm(Model model, @Valid @ModelAttribute("subfunctionPOJO") SubFuncPOJO subfunctionPOJO, BindingResult br) 
	{	
		if(br.hasErrors()) 
		{
			return "updateSubForm";
		}
		if(subfuncDAOImpl.updateSubFunction(subfunctionPOJO) == 1) 
		{
			System.out.println("Record updated successfully!!");
		}
		else 
		{
			System.out.println("Error!!!");
		}
		List<SubFuncPOJO> lis = subfuncDAOImpl. getSubFuncByCategory(temp);
		model.addAttribute("subfunctions", lis);
		return "adminView2";
	}
	
	@RequestMapping("/deleteFunction") 
	public String deleteBook(Model model, @RequestParam("id")int id, @ModelAttribute("subfunctionPOJO") SubFuncPOJO subfunctionPOJO) 
	{ 
		subfuncDAOImpl.deleteSubFunction(id); 
		List<SubFuncPOJO> lis = subfuncDAOImpl. getSubFuncByCategory(temp);
		model.addAttribute("subfunctions", lis);
	    return "adminView2"; 
    }
}
