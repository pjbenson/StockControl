package com.spring.stockcontrol;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.daomanager.RoleManager;
import com.spring.daomanager.UserManager;
import com.spring.model.Role;
import com.spring.model.User;


/**
 * Handles requests for the application home page.
 */

@Controller
@SessionAttributes("user")
public class HomeController {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private RoleManager roleManager;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView checkLoginDetails(@ModelAttribute("user")User user, BindingResult result, Map model){
		User userToLogin = userManager.checkLogin(user.getUserName(), user.getPassword());
		if(userToLogin != null){
			model.put("user", userToLogin);
			return new ModelAndView("redirect:/profile");
		}
		else{
			return new ModelAndView("redirect:/login");
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegisterPage(ModelMap model){
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("command") User user, BindingResult result){
		User checkIfUserExists = userManager.checkLogin(user.getUserName(), user.getPassword());
		Role role_user = roleManager.getRole(6);
		if(checkIfUserExists == null){
			User u = prepareUser(user, role_user);
			userManager.insertUser(u);
			return new ModelAndView("redirect:/login");
		}
		else{
			return new ModelAndView("redirect:/register");
		}
    }
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile() {
		return "profile";
	}
	
	private User prepareUser(User user, Role role){
		User u = new User();
		u.setUserName(user.getUserName());
		u.setPassword(user.getPassword());
		u.setRole(role);
		return u;
	}
	
}
