package org.jk.Web_Repo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jk.Web_Repo.DAO.AdminFuncDAOImpl;
import org.jk.Web_Repo.DAO.MainFuncDAOImpl;
import org.jk.Web_Repo.Entity.AdminFuncPOJO;
import org.jk.Web_Repo.Entity.MainFuncPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController 
{
	@Autowired
	MainFuncDAOImpl mainfuncDAOImpl;
	@Autowired
	AdminFuncDAOImpl adminfuncDAOImpl;

	@ModelAttribute("functionPOJO")
	MainFuncPOJO getMainFuncPOJO() 
	{
		return new MainFuncPOJO();
	}
	
	@ModelAttribute("adminPOJO")
	AdminFuncPOJO getAdminPOJO() 
	{
		return new AdminFuncPOJO();
	}
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException
	{
		return new ModelAndView("userType");
	}
	
	@RequestMapping(value="/h")
	public String returnhome() 
	{
		return "userType";
	}
	
	@GetMapping(value = "/adminLogin")
	public String getBuyerLogin() 
	{
		return "adminLogin";
	}
	
	
	@RequestMapping(value = "/adminView")
	public String getAdminView(@ModelAttribute("functionPOJO") MainFuncPOJO function, Model model) 
	{
		List<MainFuncPOJO> lis = mainfuncDAOImpl.getAllMainFunctions();
		model.addAttribute("functions", lis);
		return "adminView";
	}
	
	@RequestMapping(value="/validateAdmin")
	public String validatebuyer(HttpServletRequest request,@RequestParam("pass")String pass,@RequestParam("username")String username, @ModelAttribute("adminPOJO") AdminFuncPOJO adminPOJO, Model model)
	{
		System.out.println(username);
		System.out.println(pass);
		boolean is = adminfuncDAOImpl.validate(username, pass);
		if(is) 
		{
			HttpSession session = request.getSession();
			System.out.println("Correct Credentials");
			session.removeAttribute("isadminlogin");
			session.setAttribute("isadminlogin", username);
			List<MainFuncPOJO> lis = mainfuncDAOImpl.getAllMainFunctions();
			model.addAttribute("functions", lis);
			return "adminView";
		}
		else
		{
			System.out.println("Wrong Credentials");
			model.addAttribute("wrong", "Invalid Credentials Entered!");
			return "adminLogin";
		}
	}
	
	@RequestMapping(value="/changePassword")
	public String changepass()
	{
		return "passwordUpdate";
	}
	
	@RequestMapping(value="/changeadminPass")
	public String changeadminpass(HttpServletRequest request,@RequestParam("pass")String pass,@RequestParam("username")String username, @RequestParam("passnew")String newpass, Model model)
	{
		System.out.println(username);
		System.out.println(pass);
		System.out.println(newpass);
		boolean is = adminfuncDAOImpl.validate(username, pass);
		if(is) 
		{
			if(adminfuncDAOImpl.updateAdminPasswordFunction(username, newpass)==1)
			{
				System.out.println(newpass);
				System.out.println("Record Updated Successfully");
				model.addAttribute("update", "Password Changed Successfully!");
				return "adminLogin";
			}
			else
			{
				System.out.println("Wrong Credentials");
				model.addAttribute("wrong", "Invalid Credentials Entered!");
				return "adminLogin";
			}
		}
		else
		{
			System.out.println("Wrong Credentials");
			model.addAttribute("wrong", "Invalid Credentials Entered!");
			return "adminLogin";
		}
	}

	@RequestMapping(value= "/adminView2")
	public RedirectView getBuyerConfirm2()
	{
		return new RedirectView("/Web_Repo/adminView");
	}
	
	@RequestMapping(value= "/logout")
	public RedirectView logout(HttpServletRequest request)
	{
		
		HttpSession session=request.getSession();
		session.invalidate();
		return new RedirectView("/Web_Repo/");
	}

}
